package DDDTutorial_Modd.Voxl;

import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;

public class ID_NOd<Setr_Typ extends ID_NOd_Setr> extends NOd<Setr_Typ>
{
	public int ID;

	public ID_NOd(RL_LOc_Havr Parnt,Object Loc_Sorc,
		int ID,Setr_Typ NXt)
	{
		super(Parnt,Loc_Sorc,NXt);
		this.ID=ID;
	}

	public static NOd_UpdAt_Rul<ID_NOd> No_Rul_ID(Voxl_Typ[] Typg)
	{return (NOd)->{((ID_NOd_Setr)NOd.NXt).Typ=Typg[NOd.ID];};}
}