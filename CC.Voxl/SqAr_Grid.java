package DDDTutorial_Modd.Voxl;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.LOcg_By_LOc;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon;
import DDDTutorial_Modd.D3.Multi_Object;
import java.util.ArrayList;
import static CC.List.List_X.Find;

public abstract class SqAr_Grid
	extends Multi_Object<Drawbl_D3_Polygon>
	implements Typg_Havr
{
	public double Voxl_SIz;
	public int
		X_LNg,
		Y_LNg;
	public int[][] IDg;

	public RL_LOc_Havr[][] VrtXg;
		@Lin_DclAr @Finishd(Is_Finishd=true)
		public void Set_VrtXg()
		{
			VrtXg=new RL_LOc_Havr[Y_LNg+1][X_LNg+1];
			for(int Y=0;Y<Y_LNg+1;Y+=1)
			{
				for(int X=0;X<X_LNg+1;X+=1)
				{VrtXg[Y][X]=new RL_LOc_Havr_ConcrEt(this,
					X*Voxl_SIz,
					Y*Voxl_SIz,
					0);
				}
			}
		}

	public Drawbl_D3_Polygon[][] Polygong;
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public void Set_Drawbl_Atomg()
		{
			this.Polygong=new Drawbl_D3_Polygon[Y_LNg][X_LNg];
			Polyhedron=new Polyhedron(this,null);
			ArrayList<Drawbl_D3_Polygon> Polygong=new ArrayList<>();
			for(int Y=0;Y<Y_LNg;Y+=1)
			{
				for(int X=0;X<X_LNg;X+=1)
				{
					Drawbl_D3_Polygon Polygon=new Drawbl_D3_Polygon<>(
						new D3_Polygon<>(new LOcg_By_LOc(
							VrtXg[Y+1][X],
							VrtXg[Y+1][X+1],
							VrtXg[Y][X+1],
							VrtXg[Y][X])),
						Get_Typg()[0].Filr);
					this.Polygong[Y][X]=Polygon;
					Polygong.add(Polygon);
				}
			}
			Polyhedron.Set_Drawbl_Atomg(Polygong);
		}

	@Lin_DclAr @Finishd(Is_Finishd=false)
	public void Set_Gridg_From_IDg(int[][] IDg)
	{
		this.IDg=IDg;

		Set_VrtXg();

		Set_Drawbl_Atomg();
	}

	@Lin_DclAr @Finishd(Is_Finishd=false)
	public abstract void UpdAt_Voxl(int X,int Y,Voxl_Typ Typ);
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public void UpdAt_Voxl(int X,int Y,int ID)
		{UpdAt_Voxl(X,Y,Get_Typg()[ID]);}
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public void UpdAt_Voxl(int X,int Y)
		{UpdAt_Voxl(X,Y,IDg[Y][X]);}
	@Finishd(Is_Finishd=false)
	public void UpdAt_Voxlg()
	{
		for(int Y=0;Y<Y_LNg;Y+=1)
		{
			for(int X=0;X<X_LNg;X+=1)
			{UpdAt_Voxl(X,Y);}
		}
	}

	@Lin_DclAr @Finishd(Is_Finishd=false)
	public void Get_LOc(D3_Drawbl_Atom Atom,int[] LOc)
	{Find(Polygong,Atom,LOc);}
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public int[] Get_LOc(D3_Drawbl_Atom Atom)
		{return Find(Polygong,Atom);}

	public SqAr_Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,
		double Voxl_SIz,int X_LNg,int Y_LNg,int[][] IDg)
	{
		super(Parnt,LOc_SOrc);

		this.Voxl_SIz=Voxl_SIz;
		this.X_LNg=X_LNg;
		this.Y_LNg=Y_LNg;

		Set_Gridg_From_IDg(IDg);
	}
		/**Infers, X_LNg, & Y_LNg.*/
		public SqAr_Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,
			double Voxl_SIz,int[][] IDg)
		{this(Parnt,LOc_SOrc,
			Voxl_SIz,IDg[0].length,IDg.length,
			IDg);
		}
}