package cn.hcx.service;

import cn.hcx.bean.Log;
import cn.hcx.dao.LogDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("logService")
public class LogServiceImpl implements LogService {

    private LogDao logDao;

    public LogServiceImpl(LogDao logDao) {
        this.logDao = logDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Log log) {
        logDao.addLog(log);
    }
}
