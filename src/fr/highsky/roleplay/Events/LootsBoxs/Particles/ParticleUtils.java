package fr.highsky.roleplay.Events.LootsBoxs.Particles;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class ParticleUtils {


    private static final double THETA_INCREMENT = Math.PI / 18.0; // 10 degrees
    private static final int HALO_RADIUS = 1;

    //private final SpawnerManager manager;
    private static double theta = 0;

    public static void addParticle(Block b, ParticleDensity Density, ParticleType Type, ParticleEffect Effect){

        ParticleEffect effect = Effect;
        Location centre = b.getLocation().add(0.5, 0.5, 0.5);
        ParticleType particle = Type;

        ParticleDensity density = Density;

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

}
