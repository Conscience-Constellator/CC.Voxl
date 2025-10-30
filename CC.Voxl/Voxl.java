package DDDTutorial_Modd.Voxl;

import DDDTutorial_Modd.D3.Cub;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.ClEr;

public class Voxl extends Cub
{
	public Voxl(Cub_Grid_ Grid,Object LOc_SOrc,
		double LNg)
	{
		super(Grid,LOc_SOrc,
			LNg,
		ClEr);
		this.Grid=Grid;
	}

	public Cub_Grid_ Grid;
}