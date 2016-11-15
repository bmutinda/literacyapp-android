package org.literacyapp.dao;

import org.literacyapp.dao.DaoSession;
import de.greenrobot.dao.DaoException;

import java.util.Calendar;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "STUDENT_IMAGE_FEATURE".
 */
public class StudentImageFeature {

    private Long id;
    private Long studentId;
    private Calendar timeCreated;
    private String svmVector;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient StudentImageFeatureDao myDao;

    private Student student;
    private Long student__resolvedKey;


    public StudentImageFeature() {
    }

    public StudentImageFeature(Long id) {
        this.id = id;
    }

    public StudentImageFeature(Long id, Long studentId, Calendar timeCreated, String svmVector) {
        this.id = id;
        this.studentId = studentId;
        this.timeCreated = timeCreated;
        this.svmVector = svmVector;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentImageFeatureDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Calendar getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Calendar timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getSvmVector() {
        return svmVector;
    }

    public void setSvmVector(String svmVector) {
        this.svmVector = svmVector;
    }

    /** To-one relationship, resolved on first access. */
    public Student getStudent() {
        Long __key = this.studentId;
        if (student__resolvedKey == null || !student__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentDao targetDao = daoSession.getStudentDao();
            Student studentNew = targetDao.load(__key);
            synchronized (this) {
                student = studentNew;
            	student__resolvedKey = __key;
            }
        }
        return student;
    }

    public void setStudent(Student student) {
        synchronized (this) {
            this.student = student;
            studentId = student == null ? null : student.getId();
            student__resolvedKey = studentId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}