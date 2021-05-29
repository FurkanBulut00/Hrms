package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;


@Service
public class JobAdvertManager implements JobAdvertService {
	
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		if(checkField(jobAdvert).isSuccess()) {
			this.jobAdvertDao.save(jobAdvert);
			return new SuccessResult("İş alanı eklendi.");
		}
		
		return new ErrorResult("İş ilanı eklenemedi,Bilgileri kontrol ediniz.");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Basarili bir sekilde güncellendi.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("Basarili bir sekilde silindi.");
	}

	@Override
	public Result changeActiveToPassive(int id) {
		if(getById(id)==null) {
			return new ErrorResult("Sectiginiz ilan bulunamadı.");
		}
		if(getById(id).getData().isActive()==false) {
			return new ErrorResult("Sectiginiz ilan zaten kapalı!");
		}
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setActive(false);
		update(jobAdvert);
		
		return new SuccessResult("Sectiginiz ilan pasif hale getirildi.");
	}
	
	private Result checkField(JobAdvert jobAdvert) {
		if(jobAdvert.getCity()==null || jobAdvert.getJobDesription()==null || jobAdvert.getJob()==null) {
			return new ErrorResult();
		}
		if(jobAdvert.getCity().equals("")||jobAdvert.getJobDesription().equals("")||jobAdvert.getJob().equals("")) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(id));
	}

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveTrue() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrue(),"Aktif ilanlar listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPostedDate() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrueOrderByPostedDate(),"Aktif ilanlar tarihe göre sıralandı");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompany(int id) {
	
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActiveJobAdvertByCompany(id),"Şirkete ait tüm ilanlar listelendi");
	}

}
