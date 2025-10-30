package DDDTutorial_Modd.Voxl;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.TIm.Tikbl;
import DDDTutorial_Modd.D3.Cub;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import CC.Encycloped.Abs.Scal.Physc.SpAc_Object;
import java.util.ArrayList;
import java.util.List;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.ClEr;

public class NOd_Net<NOd_Typ extends NOd> extends SpAc_Object<Physc_SpAc> implements Tikbl
{
	//<editor-fold desc="SpAc">
	@Override @Finishd(Is_Finishd=false)
	public void Ad_To_SpAc(Physc_SpAc SpAc)
	{
		SpAc.Ad_Sortd_Object(this);
		SpAc.Ad_Intrnl_Physc(this);
	}
	@Override @Finishd(Is_Finishd=false)
	public void Rmov_From_SpAc(Physc_SpAc SpAc)
	{
		SpAc.Rmov_Sortd_Object(this);
		SpAc.Rmov_Intrnl_Physc(this);
	}
	//</editor-fold>

	public List<NOd_Typ> NOdg;
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public void Set_NOdg(List<NOd_Typ> NOdg)
		{
			this.NOdg=NOdg;
			RL_LOc_Havr.Parnt(this,(List<? extends RL_LOc_Havr<Physc_SpAc>>)NOdg);
		}
			@Lin_DclAr @Finishd(Is_Finishd=false)
			public void Ad_NOd(NOd_Typ NOd)
			{
				NOdg.add(NOd);
				NOd.Parnt(this);
			}
		@Lin_DclAr @Neds_Ovrid(NEds=No) @Finishd(Is_Finishd=true)
		public final int NOd_Num()
		{return NOdg.size();}
	public NOd_UpdAt_Rul<NOd_Typ> Rul;

	@Override @Finishd(Is_Finishd=false)
	public void Tik()
	{
		for(NOd_Typ NOd:NOdg)
		{Rul.CalculAt(NOd);}
		for(NOd_Typ NOd:NOdg)
		{NOd.UpdAt();}
	}

	@Finishd(Is_Finishd=false)
	public NOd_Net(RL_LOc_Havr<Physc_SpAc> Parnt,Object LOc_SOrc,List<NOd_Typ> NOdg,NOd_UpdAt_Rul<NOd_Typ> Rul)
	{
		super(Parnt,LOc_SOrc);
		Ad_Physc(new Cub(this,null,1,1,1,ClEr));
		this.NOdg=NOdg;
		this.Rul=Rul;
	}
		@Finishd(Is_Finishd=false)
		public NOd_Net(RL_LOc_Havr<Physc_SpAc> Parnt,Object LOc_SOrc,NOd_UpdAt_Rul<NOd_Typ> Rul)
		{this(Parnt,LOc_SOrc,new ArrayList<>(),Rul);}
}