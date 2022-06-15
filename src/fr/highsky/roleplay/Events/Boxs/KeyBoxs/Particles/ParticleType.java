package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Particles;

import org.bukkit.Particle;

/**
 * All possible types of particles supported by EpicSpawners
 */
public enum ParticleType {

    PORTAL(Particle.PORTAL),
    VILLAGER(Particle.VILLAGER_ANGRY),
    CLOUD(Particle.CLOUD),
    HEART(Particle.HEART),
    SQUID_INK(Particle.SQUID_INK),
    SNEEZE(Particle.SNEEZE),
    NONE(null);

    private final Particle effect;

    private ParticleType(Particle effect) {
        this.effect = effect;
    }

    /**
     * Get the name of the particle effect displayed by this type
     * 
     * @return the particle name
     */
    public Particle getEffect() {
        return effect;
    }

}
