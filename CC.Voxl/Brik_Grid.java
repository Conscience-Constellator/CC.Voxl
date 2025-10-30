package DDDTutorial_Modd.Voxl;

import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import static DDDTutorial_Modd.Voxl.VrtX_Grid.Mid_VrtX_LNg;

public class Brik_Grid extends Y_Stagrd
{
	@Override
	public void Get_Atom_LOc(D3_Drawbl_Atom Atom,double[] Box,int[] Loc)
	{
		if(Atom instanceof Drawbl_D3_Polygon Polygon)
		{
			double[] $;
			if(Polygon.Get_LOc_Num()==6)
			{$=Polygon.Get_LOc(5);}
			else
			{
				Atom.Get_Bordr_Out_Box_StRt(Box);
				if(Box[0]==Box[1])
				{$=Polygon.Get_LOc(3);}
				else
				{
					double[]
						B=Polygon.Get_LOc(3);
						$=Polygon.Get_LOc(0);
					double BY=B[1];
					if(BY>$[1])
					{$[1]=BY;}
				}
			}
			Get_Loc_SpAc$Grid($,Loc);
		}
	}
	@Override
	public int Get_Atom_LOc_Al_Axis(D3_Drawbl_Atom Atom,double[] Box,int[] Loc)
	{
		if(Atom instanceof Drawbl_D3_Polygon Polygon)
		{
			double[] $;
			int Axis;
			if(Polygon.Get_LOc_Num()==6)
			{
				$=Polygon.Get_LOc(5);
				Axis=Z_Axis;
			}
			else
			{
				Atom.Get_Bordr_Out_Box_StRt(Box);
				if(Box[0]==Box[1])
				{
					$=Polygon.Get_LOc(3);
					Axis=X_Axis;
				}
				else
				{
					double[]
						B=Polygon.Get_LOc(3);
						$=Polygon.Get_LOc(0);
					double BY=B[1];
					if(BY>$[1])
					{
						$[1]=BY;
						Axis=XYB_Axis;
					}
					else
					{Axis=XYA_Axis;}
				}
			}
			Get_Loc_SpAc$Grid($,Loc);
			return Axis;
		}
		else return -1;
	}
	@Override
	public int[] Get_TRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] Loc)
	{
		double[] Box=new double[6];
		int
			Axis=Get_Atom_LOc_Al_Axis(Atom,Box,Loc),
			X=Loc[0],
			Y=Loc[1],
			Z=Loc[2];

		if(Is_TRgetbl_Voxl(X,Y,Z))
		{return Loc;}
		//<editor-fold desc="Prepare for checking voxel on other side">
		switch(Axis)
		{
			case X_Axis->
			{
				X-=1;
				Loc[0]=X;
			}
			case Z_Axis->
			{
				Z-=1;
				Loc[2]=Z;
			}
			case XYA_Axis->
			{
				Y-=1;
				Loc[1]=Y;
			}
			case XYB_Axis->
			{
				X-=1;
				Loc[0]=X;
				Y-=1;
				Loc[1]=Y;
			}
		}
		//</editor-fold>
		if(Is_TRgetbl_Voxl(X,Y,Z))
		{return Loc;}
		else
		{return null;}
	}
	@Override
	public int[] Get_UntRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] Loc)
	{
		double[] Box=new double[6];
		int
			Axis=Get_Atom_LOc_Al_Axis(Atom,Box,Loc),
			X=Loc[0],
			Y=Loc[1],
			Z=Loc[2];

		if(Is_TRgetbl_Voxl(X,Y,Z))
		{return Loc;}
		//<editor-fold desc="Prepare for checking voxel on other side">
		switch(Axis)
		{
			case X_Axis->
			{
				X-=1;
				Loc[0]=X;
			}
			case Z_Axis->
			{
				Z-=1;
				Loc[2]=Z;
			}
			case XYA_Axis->
			{
				Y-=1;
				Loc[1]=Y;
			}
			case XYB_Axis->
			{
				X-=1;
				Loc[0]=X;
				Y-=1;
				Loc[1]=Y;
			}
		}
		//</editor-fold>
		if(Is_TRgetbl_Voxl(X,Y,Z))
		{return Loc;}
		else
		{return null;}
	}
	@Override
	public void PlAc_On_Voxl(D3_Drawbl_Atom Atom,byte ID)
	{
		int[] Loc=Get_UntRgetbl_Voxl(Atom);
		if(Is_In(Loc))
		{Set_Voxl(Loc,ID);}
	}

	@Override
	public RL_LOc_Havr[][][] MAk_VrtXg(int X_LNg,int Y_LNg,int Z_LNg)
	{
		int X_VrtX_LNg=Mid_VrtX_LNg(X_LNg);
		RL_LOc_Havr[][][] VrtXg=MAk_VrtX_ArA(X_LNg,Y_LNg,Z_LNg);
		RL_LOc_Havr[][] VrtX2;
		RL_LOc_Havr[] VrtX1;
		double Voxl_Rad=Voxl_SIz/2;
		for(int Z=0;Z<Z_LNg;Z+=1)
		{
			VrtX2=VrtXg[Z];
			for(int Y=0;Y<Y_LNg;Y+=1)
			{
				VrtX1=VrtX2[Y];
				int Stagr_Dr=1;
				for(int X=0;
					X<X_VrtX_LNg;
					X+=1,
					Stagr_Dr=-Stagr_Dr)
				{
					VrtX1[X]=new RL_LOc_Havr_ConcrEt(this,
						X*Voxl_Rad,
						Y*Voxl_SIz,
						Z*Voxl_SIz);
				}
			}
		}

		return VrtXg;
	}

	public Brik_Grid(RL_LOc_Havr Parnt,Object Loc_Sorc,double Voxl_SIz,byte[][][] IDg)
	{super(Parnt,Loc_Sorc,Voxl_SIz,IDg);}
}