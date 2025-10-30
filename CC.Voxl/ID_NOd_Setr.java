package DDDTutorial_Modd.Voxl;

import CC.Encycloped.Abs.Scal.Physc.NOd_Setr;

public class ID_NOd_Setr extends NOd_Setr<ID_NOd>
{
	public int ID;
	public Voxl_Typ Typ;
	@Override
	public void Set_NOd(ID_NOd NOd)
	{
		NOd.ID=ID;
		Typ.Set_Drawbl_Atom(NOd.Polyhedron.Drawbl_Atomg[0]);
	}

	public ID_NOd_Setr()
	{}
	public ID_NOd_Setr(Voxl_Typ Typ)
	{this.Typ=Typ;}
}