package vn.iotstar.services.implement;

import java.util.List;

import vn.iotstar.dao.IVideoDao;
import vn.iotstar.daoimpl.VideoDao;
import vn.iotstar.entity.Video;
import vn.iotstar.services.IVideoService;

public class VideoService implements IVideoService {

    private IVideoDao videoDao;
 
    public VideoService() {
        this.videoDao = new VideoDao();
    }

    @Override
    public void insert(Video video) {
        try {
            videoDao.insert(video);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Video video) {
        try {
            videoDao.update(video);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int videoId) throws Exception {
        try {
            videoDao.delete(videoId);
        } catch (Exception e) {
            throw new Exception("Xóa video thất bại với ID: " + videoId, e);
        }
    }

    @Override
    public Video findById(int videoId) {
        try {
            return videoDao.findById(videoId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Video> findAll() {
        try {
            return videoDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Video> findAll(int page, int pageSize) {
        try {
            return videoDao.findAll(page, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int count() {
        try {
            return videoDao.count();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}