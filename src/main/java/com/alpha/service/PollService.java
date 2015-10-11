package com.alpha.service;

import com.alpha.dao.PollDao;
import com.alpha.models.Item;
import com.alpha.models.ParticipantList;
import com.alpha.models.Poll;
import com.alpha.models.User;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Resource(name = "pollService")
public class PollService implements IPollService {
    private static PollDao pollDao;
    private static ParticipantListService participantListService;

    public PollService() {
        pollDao = new PollDao();
        participantListService = new ParticipantListService();
    }

    public void persist(Poll participantList) {
        pollDao.openCurrentSessionwithTransaction();
        pollDao.persist(participantList);
        pollDao.closeCurrentSessionwithTransaction();
    }

    public void update(Poll participantList) {
        pollDao.openCurrentSessionwithTransaction();
        pollDao.update(participantList);
        pollDao.closeCurrentSessionwithTransaction();
    }

    public Poll findById(Long id) {
        pollDao.openCurrentSession();
        Poll participantList = pollDao.findById(id);
        pollDao.closeCurrentSession();
        return participantList;
    }

    public void delete(Long id) {
        pollDao.openCurrentSessionwithTransaction();
        Poll poll = pollDao.findById(id);
        pollDao.delete(poll);
        pollDao.closeCurrentSessionwithTransaction();
    }

    public List<Poll> findAll() {
        pollDao.openCurrentSession();
        List<Poll> participantList = pollDao.findAll();
        pollDao.closeCurrentSession();
        return participantList;
    }

    public void deleteAll() {
        pollDao.openCurrentSessionwithTransaction();
        pollDao.deleteAll();
        pollDao.closeCurrentSessionwithTransaction();
    }

    public void addItemToPoll(Poll poll, Item item) {

    }

    public void removeItemFromPoll(Poll poll, Item item) {

    }

    public void addParticipantListsToPoll(Poll poll, ParticipantList participantList) {

    }

    public void removeParticipantListsToPoll(Poll poll, ParticipantList participantList) {

    }

    public void addUserToPoll(Poll poll, User user) {

    }

    public void removeUserFromPoll(Poll poll, User user) {

    }

    public Set<Poll> findByUser(User user) {
        pollDao.openCurrentSessionwithTransaction();
        Set<Poll> polls =  pollDao.findByUserId(user.getId());
        pollDao.closeCurrentSessionwithTransaction();
        return polls;
    }
}
