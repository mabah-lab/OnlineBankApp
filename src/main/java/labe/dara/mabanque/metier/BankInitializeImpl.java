package labe.dara.mabanque.metier;

import labe.dara.mabanque.dao.*;
import labe.dara.mabanque.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class BankInitializeImpl implements IBankInitialize{

    @Autowired
    private ClientRepository cltrRep;
    @Autowired
    private CompteRepository cpteRep;
    @Autowired
    private OperationRepository opeRep;
    @Autowired
    private IBankMetier bankrep;
    @Autowired
    private UserRepository userRep;
    @Autowired
    private RoleRepository roleRep;
    @Autowired
    private UserRoleRepository userRoleRep;

    @Override
    public void initBankData() {


        Client c1=cltrRep.save(new Client("BAH","Mamadou",new Date(),"Bruxelles"));
        Client c2=cltrRep.save(new Client("SY","Tanou",new Date(),"Dakar"));

        Compte cp1= cpteRep.save(new CompteCourant("C1", new Date(), 1000, c1, 250));
        Compte cp2= cpteRep.save(new CompteEpargne("C2", new Date(), 8000, c1, 2.5));
        Compte cp3= cpteRep.save(new CompteEpargne("C3", new Date(), 4000, c2, 3.5));
        Compte cp4= cpteRep.save(new CompteCourant("C4", new Date(), 4000, c2, 0));


        Operation op1= opeRep.save(new Retrait(new Date(),500,cp2)); Operation op2=
                opeRep.save(new Versement(new Date(),500,cp1));


        bankrep.verser("C4", 3500); bankrep.verser("C1", 200); bankrep.verser("C2",
                60); bankrep.verser("C3", 95); bankrep.retirer("C2", 50.0);
        bankrep.retirer("C1", 20.0); bankrep.retirer("C3", 15.0);
        bankrep.retirer("C4", 34.0); bankrep.virer("C3", "C1", 150);
    }

    @Override
    public void initUsersProfils() {
        User usr1= userRep.save(new User("onlinebank","$2a$12$sJDLP2Pa8ZxcO.6/EE4VduaSYY.wrGx5muyiALUB6v1Hf2DF7gKWe",true));
        User usr2= userRep.save(new User("user","$2a$12$F9/XbfM5f174w9gsoQre4uHE97ZY26NTNXRbOl2Clg8J1LfsDvaAO",true));

        Role rol1= roleRep.save(new Role("ADMIN"));
        Role rol2= roleRep.save(new Role("USER"));

        UserRole usrRol1= userRoleRep.save(new UserRole(null,usr1,rol1));
        UserRole usrRol2= userRoleRep.save(new UserRole(null,usr1,rol2));
        UserRole usrRol3= userRoleRep.save(new UserRole(null,usr2,rol2));
    }
}
