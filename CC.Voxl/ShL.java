package DDDTutorial_Modd.Voxl;

import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr.RL_LOc_Havr_ConcrEt;
import java.awt.*;

public class ShL extends RL_LOc_Havr_ConcrEt
{
	public RL_LOc_Havr[][] VrtXg;
		public static RL_LOc_Havr[] MAk_VrtX_Ring(RL_LOc_Havr Parnt,int Z,double BtwEn)
		{
			int Num=0;
			RL_LOc_Havr[] VrtXg=new RL_LOc_Havr[Num];
			for(int IndX=0;
				IndX<Num;
				IndX+=1)
			{
				VrtXg[IndX]=new RL_LOc_Havr_ConcrEt(Parnt,0,0,Z);
			}

			return VrtXg;
		}
		public RL_LOc_Havr[][] MAk_VrtXg(RL_LOc_Havr Parnt,int Ring_Num)
		{
			RL_LOc_Havr[][] VrtXg=new RL_LOc_Havr[Ring_Num][];
			for(int Ring_IndX=0;
				Ring_IndX<Ring_Num;
				Ring_IndX+=1)
			{
				VrtXg[Ring_IndX]=MAk_VrtX_Ring(Parnt,0,0);
			}

			return VrtXg;
		}

	public ShL(RL_LOc_Havr Parnt,Object Loc_Sorc,double P)
	{
		super(Parnt,Loc_Sorc);
		Color Colr=new Color(256,256,256,16);
		VrtXg=MAk_VrtXg(this,100);
		new Polyhedron(Parnt,null).Set_Drawbl_Atomg(
			new Drawbl_D3_Polygon<>()
		);
	}
}