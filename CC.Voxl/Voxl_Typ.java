package DDDTutorial_Modd.Voxl;

import CC.COd.Lin_DclAr;

import CC.Typng.Typ;
import DDDTutorial_Modd.D2.Bound_Colr_Filr;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;
import CC.Encycloped.Abs.Scal.Physc.SIt.Filr;
import static CC.Encycloped.Abs.Scal.Physc.SIt.Filr.Gar_Filr;

public class Voxl_Typ implements Typ
{
	public Filr Filr;
	public boolean
		Is_Visbl,
		Is_TRgetbl;

	@Lin_DclAr
	public void Set_Drawbl_Atom(Drawbl_Atom Atom)
	{
		Atom.Set_Filr(Filr);
		Atom.Set_Is_Visbl(Is_Visbl);
		Atom.Set_Is_TRgetbl(Is_TRgetbl);
	}

	public Voxl_Typ(boolean Is_Visbl,Object Filr_Sorc,boolean Is_TRgetbl)
	{
		this.Is_Visbl=Is_Visbl;
		this.Filr=Gar_Filr(Filr_Sorc);
		this.Is_TRgetbl=Is_TRgetbl;
	}

	public static final Voxl_Typ Shufld_Colr_Flashng=new Voxl_Typ(true,Bound_Colr_Filr.Colr_Shuflr,true);
}