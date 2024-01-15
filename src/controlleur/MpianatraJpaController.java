/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import controlleur.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modele.Mpianatra;

/**
 *
 * @author Ramih
 */
public class MpianatraJpaController implements Serializable {

    public MpianatraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mpianatra mpianatra) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mpianatra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mpianatra mpianatra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mpianatra = em.merge(mpianatra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mpianatra.getId();
                if (findMpianatra(id) == null) {
                    throw new NonexistentEntityException("The mpianatra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mpianatra mpianatra;
            try {
                mpianatra = em.getReference(Mpianatra.class, id);
                mpianatra.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mpianatra with id " + id + " no longer exists.", enfe);
            }
            em.remove(mpianatra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mpianatra> findMpianatraEntities() {
        return findMpianatraEntities(true, -1, -1);
    }

    public List<Mpianatra> findMpianatraEntities(int maxResults, int firstResult) {
        return findMpianatraEntities(false, maxResults, firstResult);
    }

    private List<Mpianatra> findMpianatraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mpianatra.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Mpianatra findMpianatra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mpianatra.class, id);
        } finally {
            em.close();
        }
    }

    public int getMpianatraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mpianatra> rt = cq.from(Mpianatra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
