package com.dsshop.member.model.dao;

import org.springframework.stereotype.Repository;

//Imple은 implements의 약자
//unique조건 때문에 두개는 안됨
//동시에 하나도 없으면 autowired 써진곳에서 에러
@Repository("dao1")
public class MemberDaoImpl implements MemberDao {

}
