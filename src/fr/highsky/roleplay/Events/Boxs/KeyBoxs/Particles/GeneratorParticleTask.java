package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Particles;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;


public class GeneratorParticleTask extends BukkitRunnable{

	private static final double THETA_INCREMENT = Math.PI / 18.0; // 10 degrees
	private static final int HALO_RADIUS = 1;

	private static GeneratorParticleTask instance;
	//private final SpawnerManager manager;
	private static double theta = 0;




	@Override
	public void run() {

		loadCommunParticle();
		loadRareParticle();
		loadLegParticle();

	}


	public void loadCommunParticle(){

		ParticleEffect effect = ParticleEffect.HALO;

		Location centre;
		centre = new Location(Bukkit.getWorld("map"), 190, 81, 209).add(0.5,0,0.5);

		ParticleType particle = ParticleType.SNEEZE;

		ParticleDensity density = ParticleDensity.NORMAL;


		if (effect == ParticleEffect.HALO) {
			double x = HALO_RADIUS * Math.cos(theta);
			double z = HALO_RADIUS * Math.sin(theta);

			centre.add(x, 0.2, z);
			centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
					null);
		} else if (effect == ParticleEffect.TARGET) {
			for (int i = 0; i < 360; i += 10) {
				double angle = Math.toRadians(i);
				double cosAngle = Math.cos(angle), sinAngle = Math.sin(angle);

				// Outer circle
				double x = 1.2 * cosAngle, z = 1.2 * sinAngle;
				centre.add(x, -0.2, z);
				centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
						null);
				centre.subtract(x, -0.2, z);

				// Inner circle
				x = 0.8 * cosAngle;
				z = 0.8 * sinAngle;
				centre.add(x, 0, z);
				centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
						null);
				centre.subtract(x, 0, z);
			}
		}




		if ((theta += THETA_INCREMENT) > 360) {
			theta = 0;
		}

	}



	public void loadRareParticle(){

		ParticleEffect effect = ParticleEffect.HALO;


		Location centre;
		centre = new Location(Bukkit.getWorld("map"), 187, 81, 206).add(0.5,0,0.5);

		ParticleType particle = ParticleType.HEART;

		ParticleDensity density = ParticleDensity.NORMAL;


		if (effect == ParticleEffect.HALO) {
			double x = HALO_RADIUS * Math.cos(theta);
			double z = HALO_RADIUS * Math.sin(theta);

			centre.add(x, 0.2, z);
			centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
					null);
		} else if (effect == ParticleEffect.TARGET) {
			for (int i = 0; i < 360; i += 10) {
				double angle = Math.toRadians(i);
				double cosAngle = Math.cos(angle), sinAngle = Math.sin(angle);

				// Outer circle
				double x = 1.2 * cosAngle, z = 1.2 * sinAngle;
				centre.add(x, -0.2, z);
				centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
						null);
				centre.subtract(x, -0.2, z);

				// Inner circle
				x = 0.8 * cosAngle;
				z = 0.8 * sinAngle;
				centre.add(x, 0, z);
				centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
						null);
				centre.subtract(x, 0, z);
			}
		}




		if ((theta += THETA_INCREMENT) > 360) {
			theta = 0;
		}

	}


	public void loadLegParticle(){

		ParticleEffect effect = ParticleEffect.HALO;

		Location centre;

		centre = new Location(Bukkit.getWorld("map"), 187, 82, 209).add(0.5,0,0.5);

		ParticleType particle = ParticleType.VILLAGER;

		ParticleDensity density = ParticleDensity.NORMAL;


		if (effect == ParticleEffect.HALO) {
			double x = HALO_RADIUS * Math.cos(theta);
			double z = HALO_RADIUS * Math.sin(theta);

			centre.add(x, 0.2, z);
			centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
					null);
		} else if (effect == ParticleEffect.TARGET) {
			for (int i = 0; i < 360; i += 10) {
				double angle = Math.toRadians(i);
				double cosAngle = Math.cos(angle), sinAngle = Math.sin(angle);

				// Outer circle
				double x = 1.2 * cosAngle, z = 1.2 * sinAngle;
				centre.add(x, -0.2, z);
				centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
						null);
				centre.subtract(x, -0.2, z);

				// Inner circle
				x = 0.8 * cosAngle;
				z = 0.8 * sinAngle;
				centre.add(x, 0, z);
				centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
						null);
				centre.subtract(x, 0, z);
			}
		}




		if ((theta += THETA_INCREMENT) > 360) {
			theta = 0;
		}

	}




	


	

	/*public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			System.out.println("player test");

			//SpawnerData data = spawner.getFirstStack().getSpawnerData();
			

			ParticleEffect effect = ParticleEffect.HALO;
			

			Location centre = p.getLocation().add(0.5, 0.5, 0.5);

			ParticleType particle = ParticleType.REDSTONE;
			
			ParticleDensity density = ParticleDensity.LIGHT;
			

			// Particle effects
			if (effect == ParticleEffect.HALO) {
				double x = HALO_RADIUS * Math.cos(theta);
				double z = HALO_RADIUS * Math.sin(theta);

				centre.add(x, 0.2, z);
				centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
						 null);
			} else if (effect == ParticleEffect.TARGET) {
				for (int i = 0; i < 360; i += 10) {
					double angle = Math.toRadians(i);
					double cosAngle = Math.cos(angle), sinAngle = Math.sin(angle);

					// Outer circle
					double x = 1.2 * cosAngle, z = 1.2 * sinAngle;
					centre.add(x, -0.2, z);
					centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
							 null);
					centre.subtract(x, -0.2, z);

					// Inner circle
					x = 0.8 * cosAngle;
					z = 0.8 * sinAngle;
					centre.add(x, 0, z);
					centre.getWorld().spawnParticle(particle.getEffect(), centre, density.getEffect(), 0, 0, 0, 0,
							  null);
					centre.subtract(x, 0, z);
				}
			}
		}

		if ((theta += THETA_INCREMENT) > 360) {
			theta = 0;
		}
	}*/

}
