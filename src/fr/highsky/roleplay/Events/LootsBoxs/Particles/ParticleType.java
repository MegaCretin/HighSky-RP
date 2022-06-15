package fr.highsky.roleplay.Events.LootsBoxs.Particles;

import org.bukkit.Particle;

/**
 * All possible types of particles supported by EpicSpawners
 */
public enum ParticleType {

    PORTAL(Particle.PORTAL),
    VILLAGER_HAPPY(Particle.VILLAGER_HAPPY),
    FLAME(Particle.FLAME),
    CLOUD(Particle.CLOUD),
    DRAGON_BREATH(Particle.DRAGON_BREATH),
    TOWN_AURA(Particle.TOWN_AURA),
    BLOCK_CRACK(Particle.BLOCK_CRACK),
    SMOKE(Particle.SMOKE_LARGE),
    EXPLOSION_NORMAL(Particle.EXPLOSION_NORMAL),
    CRIT_MAGIC(Particle.DAMAGE_INDICATOR),
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
