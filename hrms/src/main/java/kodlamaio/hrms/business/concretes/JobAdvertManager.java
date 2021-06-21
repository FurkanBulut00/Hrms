package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.JobAdvertScheduleService;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.abstracts.JobAdvertWorkStyleService;
import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.concretes.dto.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	private CityService cityService;
	private CompanyService companyService;
	private JobService jobService;
	private JobAdvertScheduleService jobAdvertScheduleService;
	private JobAdvertWorkStyleService jobAdvertWorkStyleService;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, CityService cityService, CompanyService companyService,
			JobService jobService, JobAdvertScheduleService jobAdvertScheduleService,
			JobAdvertWorkStyleService jobAdvertWorkStyleService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.cityService = cityService;
		this.companyService = companyService;
		this.jobService = jobService;
		this.jobAdvertScheduleService = jobAdvertScheduleService;
		this.jobAdvertWorkStyleService = jobAdvertWorkStyleService;
	}

	@Override
	public Result add(JobAdvertDto jobAdvertDto) {
		if (!checkField(jobAdvertDto).isSuccess()) {

			return new ErrorResult("İş ilanı eklenemedi,Bilgileri kontrol ediniz.");

		}
		JobAdvert jobAdvertAdd = new JobAdvert();
		jobAdvertAdd.setJobDesription(jobAdvertDto.getJobDesription());
		jobAdvertAdd.setSalaryMin(jobAdvertDto.getSalaryMin());
		jobAdvertAdd.setSalaryMax(jobAdvertDto.getSalaryMax());
		jobAdvertAdd.setOpenPositon(jobAdvertDto.getOpenPositon());
		jobAdvertAdd.setPostedDate(jobAdvertDto.getPostedDate());
		jobAdvertAdd.setLastApplyDate(jobAdvertDto.getLastApplyDate());
		jobAdvertAdd.setActive(jobAdvertDto.isActive());
		jobAdvertAdd.setConfirmed(jobAdvertDto.isConfirmed());
		jobAdvertAdd.setConfirmRequest(jobAdvertDto.isConfirmRequest());

		jobAdvertAdd.setCity(cityService.getByCityId(jobAdvertDto.getCityId()).getData());
		jobAdvertAdd.setJob(jobService.getByJobId(jobAdvertDto.getJobId()).getData());
		jobAdvertAdd.setCompany(companyService.getByCompanyId(jobAdvertDto.getCompanyId()).getData());
		jobAdvertAdd.setJobAdvertSchedule(
				jobAdvertScheduleService.getByJobAdvertScheduleId(jobAdvertDto.getJobAdvertScheduleId()).getData());
		jobAdvertAdd.setJobAdvertWorkStyle(
				jobAdvertWorkStyleService.getByJobAdvertWorkStyleId(jobAdvertDto.getJobAdvertWorkStyleId()).getData());

		this.jobAdvertDao.save(jobAdvertAdd);
		return new SuccessResult("İş alanı eklendi.");
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
		if (getById(id).getData() == null) {
			return new ErrorResult("Sectiginiz ilan bulunamadı.");
		}
		if (getById(id).getData().isActive() == false) {
			return new ErrorResult("Sectiginiz ilan zaten kapalı!");
		}
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setActive(false);
		update(jobAdvert);

		return new SuccessResult("Sectiginiz ilan pasif hale getirildi.");
	}

	private Result checkField(JobAdvertDto jobAdvertDto) {
		if (jobAdvertDto.getCityId() == 0 || jobAdvertDto.getJobDesription() == null || jobAdvertDto.getJobId() == 0) {
			return new ErrorResult();
		}
		if (jobAdvertDto.getJobDesription().equals("")) {
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

		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrue(),
				"Aktif ilanlar listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPostedDate() {

		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrueOrderByPostedDate(),
				"Aktif ilanlar tarihe göre sıralandı");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompany(int id) {

		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActiveJobAdvertByCompany(id),
				"Şirkete ait tüm ilanlar listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByJobAdvertIsConfirmedFalseAndConfirmRequestTrue() {
		return new SuccessDataResult<List<JobAdvert>>(
				this.jobAdvertDao.getAllByJobAdvertIsConfirmedFalseAndConfirmRequestTrue());
	}

	@Override
	public Result changePassiveToActive(int id) {
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setActive(true);
		update(jobAdvert);
		return new SuccessResult("İlan aktif edildi.");
	}

	@Override
	public Result changeConfirmRequestTrueToFalse(int id) {
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setConfirmRequest(false);
		update(jobAdvert);
		return new SuccessResult("İlan Onay Sürecinden Kaldırıldı");
	}

	@Override
	public Result changeConfirmedFalseToTrue(int id) {
		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setConfirmed(true);
		update(jobAdvert);
		return new SuccessResult("İlan Onaylandı.");
	}

}
