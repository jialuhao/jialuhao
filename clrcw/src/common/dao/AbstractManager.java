package common.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import common.constants.IConstants;

import util.PaginationSupport;


/**
 *<p>Title: </p>
 *
 *<p>Description: 用户在web层构造查询条件detachedCriteria，和可选的startIndex，调用业务bean的相应findByCriteria方法，返回一个PaginationSupport的实例</p>
 *
 *<p>Company: 航天思创</p>
 *
 * @author 李滨???
 *
 * @version 1.0
 */
public abstract class AbstractManager extends HibernateDaoSupport {

		
		private boolean cacheQueries = false;  
		private String queryCacheRegion = null;  
	  
		public boolean isCacheQueries() {
			return cacheQueries;
		}

		public String getQueryCacheRegion() {
			return queryCacheRegion;
		} 
		
	     public void setCacheQueries(boolean cacheQueries) {  
	         this.cacheQueries = cacheQueries;  
	     }  
	   
	     public void setQueryCacheRegion(String queryCacheRegion) {  
	         this.queryCacheRegion = queryCacheRegion;  
	     }  
	   
	     public void save(final Object entity) {  
	         getHibernateTemplate().save(entity);  
	     }  
	   
	     public void persist(final Object entity) {  
	         getHibernateTemplate().save(entity);  
	     }  
	   
	     public void update(final Object entity) {  
	         getHibernateTemplate().update(entity);  
	     }  
	   
	     public void delete(final Object entity) {  
	         getHibernateTemplate().delete(entity);  
	     }  
	   
	     @SuppressWarnings("unchecked")
		public Object load(final Class entity, final Serializable id) {  
	         return getHibernateTemplate().load(entity, id);  
	     }  
	   
	     @SuppressWarnings("unchecked")
		public Object get(final Class entity, final Serializable id) {  
	         return getHibernateTemplate().get(entity, id);  
	     }
	     @SuppressWarnings("unchecked")
	    public List findAllNotDr(final Class entity){
		   return getHibernateTemplate().find("from " + entity.getName());
	     }
	     
	    @SuppressWarnings("unchecked")
		public List findAll(final Class entity) {  
	         return getHibernateTemplate().find("from " + entity.getName() + " where dr='"+IConstants.DEFAULT_SIGN+"' "); 
	     }  
	    @Deprecated
	     public List<?> findByNamedQuery(final String namedQuery) {  
	         return getHibernateTemplate().findByNamedQuery(namedQuery);  
	     }  
	     @Deprecated
	     public List<?> findByNamedQuery(final String query, final Object parameter) {  
	         return getHibernateTemplate().findByNamedQuery(query, parameter);  
	     }  
	     @Deprecated
	     public List<?> findByNamedQuery(final String query, final Object[] parameters) {  
	         return getHibernateTemplate().findByNamedQuery(query, parameters);  
	     }  
	     @Deprecated
	     public List<?> find(final String query) {  
	         return getHibernateTemplate().find(query);  
	     }  
	     @Deprecated
	     public List<?> find(final String query, final Object parameter) {  
	         return getHibernateTemplate().find(query, parameter);  
	     }  
	   
	   
	     /**
	      * 
	      * 描述：通过QBC检索方式查询所有记录
	      * @param detachedCriteria
	      * @return
	      */
	     public List<?> findAllByCriteria(final DetachedCriteria detachedCriteria) {  
	         return (List<?>) getHibernateTemplate().execute(new HibernateCallback() {  
	             public Object doInHibernate(Session session) throws HibernateException {  
	                 Criteria criteria = detachedCriteria.getExecutableCriteria(session);  
	                 return criteria.list();  
	             }  
	         }, true);  
	     }  
	   
	     /**
	      * 
	      * 描述：通过QBC检索方式查询记录数
	      * @param detachedCriteria
	      * @return 
	      */
	     public int getCountByCriteria(final DetachedCriteria detachedCriteria) {  
	         Integer count = (Integer) getHibernateTemplate().execute(new HibernateCallback() {  
	             public Object doInHibernate(Session session) throws HibernateException {  
	                 Criteria criteria = detachedCriteria.getExecutableCriteria(session);  
	                 return criteria.setProjection(Projections.rowCount()).uniqueResult();  
	             }  
	         }, true);  
	         return count.intValue();  
	     }
	     
	     /**
	      * 
	      * 描述：默认第一页通过QBC检索方式查询页数
	      * @param detachedCriteria
	      * @return 分页对象
	      */
	      public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria) {  
	    	          return findPageByCriteria(detachedCriteria, PaginationSupport.PAGESIZE, 0);  
	    	      }  
	      /**
	       * 
	       * 描述：默认每页显示行数通过QBC检索方式查询页数
	       * @param detachedCriteria
	       * @param startIndex
	       * @return 分页对象
	       */
	      public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final int startIndex) {  
	    	         return findPageByCriteria(detachedCriteria, PaginationSupport.PAGESIZE, startIndex);  
	    	      }  
	      /**
	       * 
	       * 描述：通过QBC检索方式查询页数
	       * @param detachedCriteria 离线查询 你在一个session范围之外创建一个查询，并且可以使用任意的 Session来执行它
	       * @param pageSize
	       * @param startIndex
	       * @return 分页对象
	       */
	      
	      public PaginationSupport findPageByCriteria(final DetachedCriteria detachedCriteria, final int pageSize,  
	    	              								final int startIndex) {  
	    	          return (PaginationSupport) getHibernateTemplate().execute(new HibernateCallback() {  
	    	              public Object doInHibernate(Session session) throws HibernateException {  
	    	                  Criteria criteria = detachedCriteria.getExecutableCriteria(session);  
	    	                  int totalCount = ((Integer) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();  
	    	                  criteria.setProjection(null);  
	    	                  List<?> items = criteria.setFirstResult(startIndex).setMaxResults(pageSize).list();  
	    	                  PaginationSupport ps = new PaginationSupport(items, totalCount, pageSize, startIndex);  
	    	                  return ps;  
	    	              }  
	    	          }, true);  
	    	      }
	      /**
	       * 
	       * 描述：通过QBC检索方式查询页数jjj
	       * @param detachedCriteria 离线查询 你在一个session范围之外创建一个查询，并且可以使用任意的 Session来执行它
	       * @param pageSize 
	       * @param startIndex 当前索引
	       * @param order 排序
	       * @return 分页对象
	       */
	     @SuppressWarnings("unchecked")  
	     protected PaginationSupport findPageByCriteria(DetachedCriteria criteria,  
	             int startIndex, int pageSize, Order order) {  
	         DetachedCriteria clone = (DetachedCriteria) SerializationUtils.clone(criteria);  
	         clone.setProjection(Projections.rowCount());  
	        int count = getCountByCriteria(clone);  
	      
	        PaginationSupport strategy = new PaginationSupport(startIndex,pageSize,count);  
	       
	         if (order != null) {  
	             criteria.addOrder(order);  
	      }  
	        
	          List elements = getHibernateTemplate()  
	                 .findByCriteria(criteria,  
	                          strategy.getStartIndex(),
	                          pageSize);  
	        
	         return new PaginationSupport(elements,count,pageSize,startIndex);  
	      }  
}
