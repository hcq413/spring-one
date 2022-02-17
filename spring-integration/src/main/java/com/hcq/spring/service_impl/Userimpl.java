package com.hcq.spring.service_impl;

import com.hcq.spring.domain.Auctionuser;
import com.hcq.spring.domain.AuctionuserExample;
import com.hcq.spring.mapper.AuctionuserMapper;
import com.hcq.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userimpl implements UserService {

    @Autowired
    AuctionuserMapper mapper;

    @Override
    public Auctionuser Login(String username, String password) {
        AuctionuserExample example = new AuctionuserExample();
        AuctionuserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andUserpasswordEqualTo(password);
        List<Auctionuser> byExample = mapper.selectByExample(example);
        if (byExample != null && byExample.size() > 0) {
            return byExample.get(0);
        }
        return null;
    }
}
