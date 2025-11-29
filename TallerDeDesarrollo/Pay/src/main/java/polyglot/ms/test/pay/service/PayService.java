package polyglot.ms.test.pay.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import polyglot.ms.test.pay.model.PayModel;
import polyglot.ms.test.pay.repository.IPayRepository;



@Service
public class PayService  implements IPayService {
 
    @Autowired
    private IPayRepository payRepositoy;
 
    @Override
    @Transactional
    public PayModel add(PayModel payModel) {
        return payRepositoy.save(payModel);
    }
   
}
