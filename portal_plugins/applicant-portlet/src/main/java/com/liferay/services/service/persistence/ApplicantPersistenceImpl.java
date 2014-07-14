package com.liferay.services.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.services.NoSuchApplicantException;
import com.liferay.services.model.Applicant;
import com.liferay.services.model.impl.ApplicantImpl;
import com.liferay.services.model.impl.ApplicantModelImpl;
import com.liferay.services.service.persistence.ApplicantPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the applicant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Suresh Kumar
 * @see ApplicantPersistence
 * @see ApplicantUtil
 * @generated
 */
public class ApplicantPersistenceImpl extends BasePersistenceImpl<Applicant>
    implements ApplicantPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ApplicantUtil} to access the applicant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ApplicantImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByname",
            new String[] { String.class.getName() },
            ApplicantModelImpl.FIRSTNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantModelImpl.FINDER_CACHE_ENABLED, ApplicantImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_APPLICANT = "SELECT applicant FROM Applicant applicant";
    private static final String _SQL_SELECT_APPLICANT_WHERE = "SELECT applicant FROM Applicant applicant WHERE ";
    private static final String _SQL_COUNT_APPLICANT = "SELECT COUNT(applicant) FROM Applicant applicant";
    private static final String _SQL_COUNT_APPLICANT_WHERE = "SELECT COUNT(applicant) FROM Applicant applicant WHERE ";
    private static final String _FINDER_COLUMN_NAME_FIRSTNAME_1 = "applicant.firstName IS NULL";
    private static final String _FINDER_COLUMN_NAME_FIRSTNAME_2 = "applicant.firstName = ?";
    private static final String _FINDER_COLUMN_NAME_FIRSTNAME_3 = "(applicant.firstName IS NULL OR applicant.firstName = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "applicant.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Applicant exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Applicant exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ApplicantPersistenceImpl.class);
    private static Applicant _nullApplicant = new ApplicantImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Applicant> toCacheModel() {
                return _nullApplicantCacheModel;
            }
        };

    private static CacheModel<Applicant> _nullApplicantCacheModel = new CacheModel<Applicant>() {
            public Applicant toEntityModel() {
                return _nullApplicant;
            }
        };

    @BeanReference(type = ApplicantPersistence.class)
    protected ApplicantPersistence applicantPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the applicant in the entity cache if it is enabled.
     *
     * @param applicant the applicant
     */
    public void cacheResult(Applicant applicant) {
        EntityCacheUtil.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantImpl.class, applicant.getPrimaryKey(), applicant);

        applicant.resetOriginalValues();
    }

    /**
     * Caches the applicants in the entity cache if it is enabled.
     *
     * @param applicants the applicants
     */
    public void cacheResult(List<Applicant> applicants) {
        for (Applicant applicant : applicants) {
            if (EntityCacheUtil.getResult(
                        ApplicantModelImpl.ENTITY_CACHE_ENABLED,
                        ApplicantImpl.class, applicant.getPrimaryKey()) == null) {
                cacheResult(applicant);
            } else {
                applicant.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all applicants.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ApplicantImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ApplicantImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the applicant.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Applicant applicant) {
        EntityCacheUtil.removeResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantImpl.class, applicant.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Applicant> applicants) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Applicant applicant : applicants) {
            EntityCacheUtil.removeResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
                ApplicantImpl.class, applicant.getPrimaryKey());
        }
    }

    /**
     * Creates a new applicant with the primary key. Does not add the applicant to the database.
     *
     * @param applicantId the primary key for the new applicant
     * @return the new applicant
     */
    public Applicant create(long applicantId) {
        Applicant applicant = new ApplicantImpl();

        applicant.setNew(true);
        applicant.setPrimaryKey(applicantId);

        return applicant;
    }

    /**
     * Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param applicantId the primary key of the applicant
     * @return the applicant that was removed
     * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Applicant remove(long applicantId)
        throws NoSuchApplicantException, SystemException {
        return remove(Long.valueOf(applicantId));
    }

    /**
     * Removes the applicant with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the applicant
     * @return the applicant that was removed
     * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Applicant remove(Serializable primaryKey)
        throws NoSuchApplicantException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Applicant applicant = (Applicant) session.get(ApplicantImpl.class,
                    primaryKey);

            if (applicant == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchApplicantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(applicant);
        } catch (NoSuchApplicantException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Applicant removeImpl(Applicant applicant)
        throws SystemException {
        applicant = toUnwrappedModel(applicant);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, applicant);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(applicant);

        return applicant;
    }

    @Override
    public Applicant updateImpl(
        com.liferay.services.model.Applicant applicant, boolean merge)
        throws SystemException {
        applicant = toUnwrappedModel(applicant);

        boolean isNew = applicant.isNew();

        ApplicantModelImpl applicantModelImpl = (ApplicantModelImpl) applicant;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, applicant, merge);

            applicant.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ApplicantModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((applicantModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        applicantModelImpl.getOriginalFirstName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);

                args = new Object[] { applicantModelImpl.getFirstName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
            ApplicantImpl.class, applicant.getPrimaryKey(), applicant);

        return applicant;
    }

    protected Applicant toUnwrappedModel(Applicant applicant) {
        if (applicant instanceof ApplicantImpl) {
            return applicant;
        }

        ApplicantImpl applicantImpl = new ApplicantImpl();

        applicantImpl.setNew(applicant.isNew());
        applicantImpl.setPrimaryKey(applicant.getPrimaryKey());

        applicantImpl.setApplicantId(applicant.getApplicantId());
        applicantImpl.setFirstName(applicant.getFirstName());
        applicantImpl.setMiddleName(applicant.getMiddleName());
        applicantImpl.setLastName(applicant.getLastName());
        applicantImpl.setQualifications(applicant.getQualifications());
        applicantImpl.setAddressLine1(applicant.getAddressLine1());
        applicantImpl.setAddressLine2(applicant.getAddressLine2());
        applicantImpl.setCity(applicant.getCity());
        applicantImpl.setStreet(applicant.getStreet());
        applicantImpl.setPostCode(applicant.getPostCode());
        applicantImpl.setCreateDate(applicant.getCreateDate());
        applicantImpl.setModifiedDate(applicant.getModifiedDate());

        return applicantImpl;
    }

    /**
     * Returns the applicant with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the applicant
     * @return the applicant
     * @throws com.liferay.portal.NoSuchModelException if a applicant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Applicant findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the applicant with the primary key or throws a {@link com.liferay.services.NoSuchApplicantException} if it could not be found.
     *
     * @param applicantId the primary key of the applicant
     * @return the applicant
     * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Applicant findByPrimaryKey(long applicantId)
        throws NoSuchApplicantException, SystemException {
        Applicant applicant = fetchByPrimaryKey(applicantId);

        if (applicant == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + applicantId);
            }

            throw new NoSuchApplicantException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                applicantId);
        }

        return applicant;
    }

    /**
     * Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the applicant
     * @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Applicant fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the applicant with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param applicantId the primary key of the applicant
     * @return the applicant, or <code>null</code> if a applicant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Applicant fetchByPrimaryKey(long applicantId)
        throws SystemException {
        Applicant applicant = (Applicant) EntityCacheUtil.getResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
                ApplicantImpl.class, applicantId);

        if (applicant == _nullApplicant) {
            return null;
        }

        if (applicant == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                applicant = (Applicant) session.get(ApplicantImpl.class,
                        Long.valueOf(applicantId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (applicant != null) {
                    cacheResult(applicant);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(ApplicantModelImpl.ENTITY_CACHE_ENABLED,
                        ApplicantImpl.class, applicantId, _nullApplicant);
                }

                closeSession(session);
            }
        }

        return applicant;
    }

    /**
     * Returns all the applicants where firstName = &#63;.
     *
     * @param firstName the first name
     * @return the matching applicants
     * @throws SystemException if a system exception occurred
     */
    public List<Applicant> findByname(String firstName)
        throws SystemException {
        return findByname(firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applicants where firstName = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param firstName the first name
     * @param start the lower bound of the range of applicants
     * @param end the upper bound of the range of applicants (not inclusive)
     * @return the range of matching applicants
     * @throws SystemException if a system exception occurred
     */
    public List<Applicant> findByname(String firstName, int start, int end)
        throws SystemException {
        return findByname(firstName, start, end, null);
    }

    /**
     * Returns an ordered range of all the applicants where firstName = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param firstName the first name
     * @param start the lower bound of the range of applicants
     * @param end the upper bound of the range of applicants (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching applicants
     * @throws SystemException if a system exception occurred
     */
    public List<Applicant> findByname(String firstName, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { firstName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
            finderArgs = new Object[] { firstName, start, end, orderByComparator };
        }

        List<Applicant> list = (List<Applicant>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Applicant applicant : list) {
                if (!Validator.equals(firstName, applicant.getFirstName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_APPLICANT_WHERE);

            if (firstName == null) {
                query.append(_FINDER_COLUMN_NAME_FIRSTNAME_1);
            } else {
                if (firstName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_NAME_FIRSTNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_NAME_FIRSTNAME_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(ApplicantModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (firstName != null) {
                    qPos.add(firstName);
                }

                list = (List<Applicant>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first applicant in the ordered set where firstName = &#63;.
     *
     * @param firstName the first name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching applicant
     * @throws com.liferay.services.NoSuchApplicantException if a matching applicant could not be found
     * @throws SystemException if a system exception occurred
     */
    public Applicant findByname_First(String firstName,
        OrderByComparator orderByComparator)
        throws NoSuchApplicantException, SystemException {
        Applicant applicant = fetchByname_First(firstName, orderByComparator);

        if (applicant != null) {
            return applicant;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("firstName=");
        msg.append(firstName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicantException(msg.toString());
    }

    /**
     * Returns the first applicant in the ordered set where firstName = &#63;.
     *
     * @param firstName the first name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching applicant, or <code>null</code> if a matching applicant could not be found
     * @throws SystemException if a system exception occurred
     */
    public Applicant fetchByname_First(String firstName,
        OrderByComparator orderByComparator) throws SystemException {
        List<Applicant> list = findByname(firstName, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last applicant in the ordered set where firstName = &#63;.
     *
     * @param firstName the first name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching applicant
     * @throws com.liferay.services.NoSuchApplicantException if a matching applicant could not be found
     * @throws SystemException if a system exception occurred
     */
    public Applicant findByname_Last(String firstName,
        OrderByComparator orderByComparator)
        throws NoSuchApplicantException, SystemException {
        Applicant applicant = fetchByname_Last(firstName, orderByComparator);

        if (applicant != null) {
            return applicant;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("firstName=");
        msg.append(firstName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchApplicantException(msg.toString());
    }

    /**
     * Returns the last applicant in the ordered set where firstName = &#63;.
     *
     * @param firstName the first name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching applicant, or <code>null</code> if a matching applicant could not be found
     * @throws SystemException if a system exception occurred
     */
    public Applicant fetchByname_Last(String firstName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByname(firstName);

        List<Applicant> list = findByname(firstName, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the applicants before and after the current applicant in the ordered set where firstName = &#63;.
     *
     * @param applicantId the primary key of the current applicant
     * @param firstName the first name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next applicant
     * @throws com.liferay.services.NoSuchApplicantException if a applicant with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Applicant[] findByname_PrevAndNext(long applicantId,
        String firstName, OrderByComparator orderByComparator)
        throws NoSuchApplicantException, SystemException {
        Applicant applicant = findByPrimaryKey(applicantId);

        Session session = null;

        try {
            session = openSession();

            Applicant[] array = new ApplicantImpl[3];

            array[0] = getByname_PrevAndNext(session, applicant, firstName,
                    orderByComparator, true);

            array[1] = applicant;

            array[2] = getByname_PrevAndNext(session, applicant, firstName,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Applicant getByname_PrevAndNext(Session session,
        Applicant applicant, String firstName,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_APPLICANT_WHERE);

        if (firstName == null) {
            query.append(_FINDER_COLUMN_NAME_FIRSTNAME_1);
        } else {
            if (firstName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_FIRSTNAME_3);
            } else {
                query.append(_FINDER_COLUMN_NAME_FIRSTNAME_2);
            }
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }
        else {
            query.append(ApplicantModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (firstName != null) {
            qPos.add(firstName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(applicant);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Applicant> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the applicants.
     *
     * @return the applicants
     * @throws SystemException if a system exception occurred
     */
    public List<Applicant> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the applicants.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of applicants
     * @param end the upper bound of the range of applicants (not inclusive)
     * @return the range of applicants
     * @throws SystemException if a system exception occurred
     */
    public List<Applicant> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the applicants.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of applicants
     * @param end the upper bound of the range of applicants (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of applicants
     * @throws SystemException if a system exception occurred
     */
    public List<Applicant> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Applicant> list = (List<Applicant>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_APPLICANT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_APPLICANT.concat(ApplicantModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Applicant>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Applicant>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the applicants where firstName = &#63; from the database.
     *
     * @param firstName the first name
     * @throws SystemException if a system exception occurred
     */
    public void removeByname(String firstName) throws SystemException {
        for (Applicant applicant : findByname(firstName)) {
            remove(applicant);
        }
    }

    /**
     * Removes all the applicants from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Applicant applicant : findAll()) {
            remove(applicant);
        }
    }

    /**
     * Returns the number of applicants where firstName = &#63;.
     *
     * @param firstName the first name
     * @return the number of matching applicants
     * @throws SystemException if a system exception occurred
     */
    public int countByname(String firstName) throws SystemException {
        Object[] finderArgs = new Object[] { firstName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NAME,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_APPLICANT_WHERE);

            if (firstName == null) {
                query.append(_FINDER_COLUMN_NAME_FIRSTNAME_1);
            } else {
                if (firstName.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_NAME_FIRSTNAME_3);
                } else {
                    query.append(_FINDER_COLUMN_NAME_FIRSTNAME_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (firstName != null) {
                    qPos.add(firstName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of applicants.
     *
     * @return the number of applicants
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_APPLICANT);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the applicant persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.services.model.Applicant")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Applicant>> listenersList = new ArrayList<ModelListener<Applicant>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Applicant>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ApplicantImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
