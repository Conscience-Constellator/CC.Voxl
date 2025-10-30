package DDDTutorial_Modd.Voxl;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import DDDTutorial_Modd.ConstL.Conectn_;
import DDDTutorial_Modd.D2.Bound_Colr_Filr;
import DDDTutorial_Modd.D2.Drawbl_Crcl_TMplat;
import DDDTutorial_Modd.D3.D2$3;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.NOd_Object;
import CC.Encycloped.Abs.Scal.Physc.NOd_Setr;
import java.awt.*;
import static DDDTutorial_Modd.Voxl.CL.ConwA_Typg;
import static MAn.Physc_.SphEr_Atom;
import static java.awt.Color.white;
import static java.util.concurrent.ThreadLocalRandom.current;

public class NOd<Setr_Typ extends NOd_Setr> extends NOd_Object
{
	public Polyhedron Polyhedron;

	public Setr_Typ NXt;
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public void Set_NXt(Setr_Typ NXt)
		{this.NXt=NXt;}
		@Override @Finishd(Is_Finishd=false)
		public void UpdAt()
		{
			super.UpdAt();
			NXt.Set_NOd(this);
		}

	@Finishd(Is_Finishd=false)
	public NOd(RL_LOc_Havr Parnt,Object LOc_SOrc,
		Setr_Typ NXt)
	{
		super(Parnt,LOc_SOrc);

		Polyhedron=(Polyhedron)Get_Physc_LMNt_Cast("SEn");
		Polyhedron.Set_Drawbl_Atomg(SphEr_Atom(Polyhedron,1,white));
		Set_NXt(NXt);
	}

	@Finishd(Is_Finishd=false)
	public static Drawbl_Crcl_TMplat Get_Crcl(NOd NOd)
	{
		return
			(Drawbl_Crcl_TMplat)(
				(D2$3)
					NOd.Polyhedron.Drawbl_Atomg[0]).Get_TMplat();
	}
	@Finishd(Is_Finishd=false)
	public static void Set_Colr(NOd NOd,Color Colr)
	{((Bound_Colr_Filr)Get_Crcl(NOd).Get_Filr()).Set_Colr(Colr);}
		@Finishd(Is_Finishd=false)
		public static void Set_Colr(NOd NOd,int Colr)
		{Set_Colr(NOd,new Color(Colr));}

	public class StAt_Setr<NOd_Typ extends NOd> extends NOd_Setr<NOd_Typ>
	{
		public Color Colr;
			@Override @Finishd(Is_Finishd=false)
			public void Set_NOd(NOd_Typ NOd)
			{Set_Colr(NOd,Colr);}

		@Finishd(Is_Finishd=false)
		public StAt_Setr()
		{}
	}

	public static final NOd_Setr Colr_Shuflr=new NOd_Setr<NOd>(){
		@Override
		public void Set_NOd(NOd NOd)
		{Set_Colr(NOd,current().nextInt());}
	};

	public static final NOd_UpdAt_Rul<ID_NOd> ConwA=(NOd)->
	{
		int AlIv_Num=0;
		for(Conectn_<ID_NOd> Conectn:NOd.Conectng)
		{
			if(Conectn.Othr(NOd).ID>0)
			{AlIv_Num+=1;}
		}
		int Is_On=(NOd.ID==0)?
			((AlIv_Num==3)?1:0):
			((AlIv_Num<2||AlIv_Num>4)?0:1);
		ID_NOd_Setr NXt=(ID_NOd_Setr)NOd.NXt;
		NXt.ID=Is_On;
		NXt.Typ=ConwA_Typg[Is_On];
	};
}