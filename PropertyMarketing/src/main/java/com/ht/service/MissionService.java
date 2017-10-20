package com.ht.service;

import com.ht.bean.Mission;
import com.ht.common.bean.Pager;

import java.util.List;

public interface MissionService extends BaseService<String,Mission> {

    Pager<Mission> listMissionByMonth(Pager<Mission> pager,String month);

    Pager<Mission> listMissionByEmployeeId(Pager<Mission> pager,String employeeId);
}
