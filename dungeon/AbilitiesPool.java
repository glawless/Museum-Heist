package dungeon;
import java.util.*;

public class AbilitiesPool {

	// We made these static so we could call them in our factories correctly Tom said it was OK
		private static HashMap<String, Abilities> attacks = new HashMap<>();
		private static Abilities attack;

		public static Abilities abililtyFactory(String character) {
			if (attacks.containsKey(character)) {
				attack = attacks.get(character);
			} else {
				if (character.equals("Gunslinger")) {
					attacks.put(character, new GunzerkerAttack());
					attack = new GunzerkerAttack();
				}

				if (character.equals("FemmeFatale")) {
					attacks.put(character, new Distraction());
					attack = new Distraction();
				}

				if (character.contentEquals("Medic")) {
					attacks.put(character, new HealthGrenade());
					attack = new HealthGrenade();
				}

				if (character.contentEquals("Demolitionist")) {
					attacks.put(character, new MOAB());
					attack = new MOAB();
				}

				if (character.contentEquals("Pyromaniac")) {
					attacks.put(character, new Pyrotechnics());
					attack = new Pyrotechnics();
				}

				if (character.contentEquals("BigBoomer")) {
					attacks.put(character, new Entitlement());
					attack = new Entitlement();
				}

				if (character.contentEquals("Archrival")) {
					attacks.put(character, new ArcOfTheCovenant());
					attack = new ArcOfTheCovenant();
				}

				if (character.contentEquals("GuardDog")) {
					attacks.put(character, new Bite());
					attack = new Bite();
				}

				if (character.contentEquals("DonutSlinger")) {
					attacks.put(character, new CinnamonTwistARang());
					attack = new CinnamonTwistARang();
				}

				if (character.contentEquals("Swat")) {
					attacks.put(character, new FlashLight());
					attack = new FlashLight();
				}

				if (character.contentEquals("MuseumSecurity")) {
					attacks.put(character, new Taser());
					attack = new Taser();
				}

			}

			return attack;
		}
}

