package medicinska.kozmetika.service.impl;

import java.util.List;
import java.util.Properties;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import medicinska.kozmetika.model.Expert;
import medicinska.kozmetika.model.UpitKorisnika;
import medicinska.kozmetika.repository.ExpertRepository;
import medicinska.kozmetika.service.ExpertService;

@Service
@Transactional
public class JpaExpertServiceImpl implements ExpertService {

	@Autowired
	private ExpertRepository expertRepository;

	@Override
	public List<Expert> findAll() {
		return expertRepository.findAll();
	}

	@Override
	public Expert findOne(Long id) {
		return expertRepository.getOne(id);

	}

	@Override
	public Expert save(Expert expert) {
		return expertRepository.save(expert);
	}

	@Override
	public Expert delete(Long id) {

		Expert expert = expertRepository.getOne(id);

		if (expert != null) {
			expertRepository.delete(expert);
		}

		return expert;
	}

	@Override
	public void sendEmail(Long id, UpitKorisnika upitKorisnika) {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername(upitKorisnika.getEmail());
	    mailSender.setPassword(upitKorisnika.getLozinka());
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    SimpleMailMessage message = new SimpleMailMessage(); 
	    
	    Expert expert = expertRepository.getOne(id);
        message.setTo(expert.getEmail()); 
        message.setSubject("Slanje upita o medicinskoj kozmetici"); 
        message.setText(upitKorisnika.getText());
        
        mailSender.send(message);
	}

}
