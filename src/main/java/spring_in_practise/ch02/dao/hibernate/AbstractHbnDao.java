package spring_in_practise.ch02.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.util.ReflectionUtils;
import spring_in_practise.dao.Dao;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.lang.reflect.ParameterizedType;

public class AbstractHbnDao<T extends Object> implements Dao<T> {

    @Inject
    private SessionFactory sessionFactory;

    private Class<T> domainClass;

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    @SuppressWarnings("unchecked")
    private Class<T> getDomainClass() {
        if (domainClass == null) {
            ParameterizedType thisType =
                    (ParameterizedType) getClass().getGenericSuperclass();
            this.domainClass =
                    (Class<T>) thisType.getActualTypeArguments()[0];
        }
        return domainClass;
    }

    private String getDomainClassName() {
        return getDomainClass().getName();
    }

    @Override
    public void create(T t) {
        Method method = ReflectionUtils.findMethod(getDomainClass(), "setDateCreated", new Class[]{Date.class});
        if (method != null) {
            try {
                method.invoke(t, new Date());
            } catch (Exception e) {

            }
        }

        getSession().save(t);
    }

    @Override
    public T get(Serializable id) {
        return getSession().get(getDomainClass(), id);
    }

    @Override
    public T load(Serializable id) {
        return getSession().load(getDomainClass(), id);
    }

    @Override
    public List<T> getAll() {
        return getSession().createQuery("from " + getDomainClassName()).list();
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    @Override
    public void delete(Serializable id) {
        //这里用load就很合理，delete只根据id删除，而load也只把id丢到代理类中，就不需要再额外去查一次数据库
        getSession().delete(load(id));
    }

    @Override
    public void deleteAll() {
        getSession().createQuery("delete " + getDomainClassName()).executeUpdate();
    }

    @Override
    public long count() {
        return (long) getSession().createQuery("select count(*) from " + getDomainClassName()).uniqueResult();
    }

    @Override
    public boolean exists(Serializable id) {
        return (get(id) != null);
    }
}
