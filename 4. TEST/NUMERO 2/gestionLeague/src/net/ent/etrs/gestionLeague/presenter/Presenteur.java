package net.ent.etrs.gestionLeague.presenter;

import net.ent.etrs.gestionLeague.models.entities.Challenge;
import net.ent.etrs.gestionLeague.models.entities.League;
import net.ent.etrs.gestionLeague.models.entities.Personnage;
import net.ent.etrs.gestionLeague.models.entities.exceptions.EntitiesFactoryException;
import net.ent.etrs.gestionLeague.models.facade.FacadeMetier;
import net.ent.etrs.gestionLeague.models.facade.exception.BusinessException;
import net.ent.etrs.gestionLeague.presenter.exception.PresenteurException;
import net.ent.etrs.gestionLeague.presenter.references.ConstantesPresenteur;
import net.ent.etrs.gestionLeague.views.exception.ViewException;
import net.ent.etrs.gestionLeague.views.facade.FacadeView;

import java.util.*;

public class Presenteur {

    FacadeMetier facadeMetier;

    FacadeView facadeView;

    private boolean estInitialise;

    public Presenteur(FacadeMetier facadeMetier, FacadeView facadeView) throws PresenteurException {
        this.setFacadeMetier(facadeMetier);
        this.setFacadeView(facadeView);
    }

    public void setFacadeMetier(FacadeMetier facadeMetier) throws PresenteurException {
        if (Objects.isNull(facadeMetier)) {
            throw new PresenteurException(ConstantesPresenteur.FACADE_MET_ERROR);
        }
        this.facadeMetier = facadeMetier;
    }

    public void setFacadeView(FacadeView facadeView) throws PresenteurException {
        if (Objects.isNull(facadeView)) {
            throw new PresenteurException(ConstantesPresenteur.FACADE_VIEW_ERROR);
        }
        this.facadeView = facadeView;
    }

    public void start() {
        int choix;
        do {
            List<String> menu = facadeView.afficherMenuPrincipal();
            choix = facadeView.lectureChoix(menu.size());
            gererChoix(choix);
        } while (choix != 0);
    }

    private void gererChoix(int choix) {
        switch (choix) {
            case 1 -> initialisation();
            case 2 -> ajouterLeague();
            case 3 -> afficherLeagues();
            case 4 -> afficherChallengesUneLeague();
            case 5 -> afficherPersonnagesUneLeague();
            case 6 -> afficherLeaguesAvec3MeilleursBuilds();
        }
    }

    private void ajouterLeague() {
        try {
            League league = this.facadeView.saisirNouvelleLeague();
            facadeMetier.saveLeague(league);

            Map<League, Challenge> leagueChallengeMap = new HashMap<>();
            Map<League, Personnage> leaguePersonnageMap = new HashMap<>();
            do {
                Set<Challenge> setChallenges = new HashSet<>(this.facadeMetier.findAllChallenges());
                Challenge challenge = facadeView.choisirChallenge(setChallenges);
                leagueChallengeMap.put(league, challenge);
            } while (facadeView.lectureChoixBoolean("Voulez- vous choisir un autre challenge ?"));

        } catch (EntitiesFactoryException | ViewException | BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherLeagues() {
        try {
            Set<League> leagues = facadeMetier.findAllLeagues();
            facadeView.afficherToutesLesLeague(leagues.stream().toList());
        } catch (BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherChallengesUneLeague() {
        try {
            Set<League> leagues = facadeMetier.findAllLeagues();
            League l = facadeView.choisirLeague(leagues);
            Set<Challenge> challengesTriee = new TreeSet<>(facadeMetier.findAllChallenges());
            facadeView.afficherlesChallenges(challengesTriee.stream().toList());

        } catch (BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherPersonnagesUneLeague() {
        try {
            Set<League> leagues = facadeMetier.findAllLeagues();
            League l = facadeView.choisirLeague(leagues);
            Set<Personnage> personnagesTriee = new TreeSet<>(facadeMetier.findAllPersonnages());
            facadeView.afficherlesPersonnages(personnagesTriee.stream().toList());
        } catch (BusinessException e) {
            facadeView.afficherMessageErreur(e.getMessage());
        }
    }

    private void afficherLeaguesAvec3MeilleursBuilds() {
    }

    private void initialisation() {
        if (!estInitialise) {
            List<String> init = new ArrayList<>();
            //Chargement League Crucible
            init.add("LEAGUE;Crucible;07/04/2023;");
            init.add("CHALLENGE;Beginner's Basics;Complete each of the following tasks.;3;");
            init.add("CHALLENGE;Melted Machinations;Complete each of the following encounters.;4;");
            init.add("CHALLENGE;Peddler's Produce I;Complete vendor recipes to receive each of the following items. A vendor recipe is when you trade a specific combination of items to a vendor, not when you buy items from their purchase screen.;4;");
            init.add("CHALLENGE;Act Adversaries I;Complete each of the following encounters.;5;");
            init.add("CHALLENGE;Dangerous Deeds;Complete each of the following encounters.;4;");
            init.add("CHALLENGE;Spreading Strength;Fully allocate Crucible Passive Skill Trees on items that have the following maximum depths.;3;");
            init.add("CHALLENGE;Act Adversaries II;Complete each of the following encounters.;5;");
            init.add("CHALLENGE;Pantheonic Prowess;Unlock all of the Pantheon Powers.;12;");
            init.add("CHALLENGE;Abhorrent Abysses;Complete each of the following Abyss encounters.;4;");
            init.add("CHALLENGE;Essential Essences;Complete each of the following Essence encounters.;8;");
            init.add("PERSONNAGE;1;melounie_no_practice;Pathfinder;100;");
            init.add("PERSONNAGE;2;Solt_no_practice;Occultist;100;");
            init.add("PERSONNAGE;3;Misha_no_practice;Guardian;100;");
            init.add("PERSONNAGE;4;Golandec_no_practice;Deadeye;100;");
            init.add("PERSONNAGE;5;LiveOnTwitchTV;Champion;100;");
            init.add("PERSONNAGE;6;MicsTalamoaning;Deadeye;100;");
            init.add("PERSONNAGE;7;ChuTalamoaning;Guardian;100;");
            init.add("PERSONNAGE;8;Enzyme_FocusNonslaught;Guardian;100;");
            init.add("PERSONNAGE;9;Arwolf_FocusNonslaught;Elementalist;100;");
            init.add("PERSONNAGE;10;Beanies_FocusNonslaught;Deadeye;100;");
            init.add("PERSONNAGE;11;sbb_cf;Champion;100;");
            init.add("PERSONNAGE;12;TR_MAINS_GIGA_CLOWN;Pathfinder;100;");
            init.add("PERSONNAGE;13;XSE;Trickster;100;");
            init.add("PERSONNAGE;14;Rudo_StanceChangeChange;Champion;100;");
            init.add("PERSONNAGE;15;SHKOOSS;Champion;100;");
            init.add("PERSONNAGE;16;DeathIsTheOnlyAdventure;Gladiator;100;");
            init.add("PERSONNAGE;17;DDD_EZA_XSE;Gladiator;100;");
            init.add("PERSONNAGE;18;uhdSTOFASTINKER;Champion;100;");
            init.add("PERSONNAGE;19;DAD_DICK_NICE_GUY;Trickster;100;");
            init.add("PERSONNAGE;20;CloudConnected;Juggernaut;100;");
            // Chargement de la league Blight
            init.add("LEAGUE;Blight;06/09/2019;09/12/2019;");
            init.add("CHALLENGE;Complete these Encounters I;Complete each of the following Encounters;5;");
            init.add("CHALLENGE;Build Blight Towers I;Build each of the following Blight Towers.;6;");
            init.add("CHALLENGE;Complete Vendor Recipes;Complete vendor recipes to receive each of the following items.;10;");
            init.add("CHALLENGE;Defeat these Act Bosses II;Defeat each of the following Unique Bosses.;5;");
            init.add("CHALLENGE;Defeat Blight Rare Monsters;Defeat each of the following Rare Blight Monsters;77;");
            init.add("CHALLENGE;Defeat Elder Guardians and Elder;Defeat The Elder and each of his Guardians.;5;");
            init.add("CHALLENGE;Defeat Rogue Exiles;Defeat each of the following Rogue Exiles;22;");
            init.add("CHALLENGE;Craft Modifiers;Use the Crafting Bench to craft a modifier on the following item slots.;12;");
            init.add("CHALLENGE;Turn in Divination Cards;Turn in Divination Cards which specifically grant each of the following reward types.;7;");
            init.add("CHALLENGE;Complete Blight Encounters II;Complete each of the following Encounters.;4;");
            init.add("PERSONNAGE;1;HavocZM;Deadeye;100;");
            init.add("PERSONNAGE;2;WhereIsMyPiscator;Deadeye;100;");
            init.add("PERSONNAGE;3;Bane_NoBeyondNoFun;Guardian;100;");
            init.add("PERSONNAGE;4;Estoydoramio;Assassin;100;");
            init.add("PERSONNAGE;5;Ontop_Blight;Raider;100;");
            init.add("PERSONNAGE;6;BOO_ONE_SHOT;Raider;100;");
            init.add("PERSONNAGE;7;Falling_Blight;Deadeye;100;");
            init.add("PERSONNAGE;8;IceColdBlight;Occultist;100;");
            init.add("PERSONNAGE;9;BlindToYou;Slayer;100;");
            init.add("PERSONNAGE;10;BB_Blight;Necromancer;100;");
            init.add("PERSONNAGE;11;PaZam_NoBeyondNoFun;Inquisitor;100;");
            init.add("PERSONNAGE;12;Sharps;Deadeye;100;");
            init.add("PERSONNAGE;13;KittymancerDerp;Necromancer;100;");
            init.add("PERSONNAGE;14;Opyat_saporchu_autistu;Ascendant;100;");
            init.add("PERSONNAGE;15;Sarkasmos_Dead;Assassin;100;");
            init.add("PERSONNAGE;16;LumoTowerSlave;Occultist;100;");
            init.add("PERSONNAGE;17;towerZ_Aura;Ascendant;100;");
            init.add("PERSONNAGE;18;karaluch_blight;Necromancer;100;");
            init.add("PERSONNAGE;19;SCUFFED_GAME_AT_BEST;Assassin;100;");
            init.add("PERSONNAGE;20;BatteryDrainme;Trickster;100;");
            //Chargement de la league The Forbidden Sanctum
            init.add("LEAGUE;The Forbidden Sanctum;09/12/2022;07/04/2023;");
            init.add("CHALLENGE;Complete Delirium Encounters I;Complete each of the following Encounters.;3;");
            init.add("CHALLENGE;Complete these Quests;Complete each of the following quests.;5;");
            init.add("CHALLENGE;Defeat these Act Bosses I;Defeat each of the following Unique Act Bosses.;5;");
            init.add("CHALLENGE;Complete these Encounters III;Complete each of the following Encounters.;4;");
            init.add("CHALLENGE;Use Essences;Use Essences on each of the following item slots.;9;");
            init.add("CHALLENGE;Defeat these Act Bosses III;Defeat each of the following Unique Act Bosses.;5;");
            init.add("CHALLENGE;Defeat Delirium Monsters;Defeat Rage, Spite, Disgust, Malice, Fury and Turmoil Delirium monsters at each of the following rarities.;3;");
            init.add("CHALLENGE;Defeat the Conquerors of the Atlas;Defeat each of the following Conquerors of the Atlas.;5;");
            init.add("CHALLENGE;Complete Vendor Recipes Unique;Complete vendor recipes to receive each of the following items.;8;");
            init.add("CHALLENGE;Craft items using Currencies;Use each of the following currencies to add or modify modifiers on items.;8;");
            init.add("CHALLENGE;Turn in Divination Cards I;Turn in Divination Cards which specifically grant each of the following reward types.;6;");
            init.add("PERSONNAGE;1;AAAAAAAA;Deadeye;100;");
            init.add("PERSONNAGE;2;karaluch_ritual;Necromancer;100;");
            init.add("PERSONNAGE;3;AuraStacker;Ascendant;100;");
            init.add("PERSONNAGE;4;Spleexzblast;Assassin;100;");
            init.add("PERSONNAGE;5;blindgaming;Necromancer;100;");
            init.add("PERSONNAGE;6;DnilB_Dede;Guardian;100;");
            init.add("PERSONNAGE;7;WORD_DOT_EXE;Trickster;100;");
            init.add("PERSONNAGE;8;Ric_Flair__Wooooooooooo;Trickster;100;");
            init.add("PERSONNAGE;9;OxirityZoom;Assassin;100;");
            init.add("PERSONNAGE;10;jimjimRitual;Assassin;100;");
            init.add("PERSONNAGE;11;Tomtex;Occultist;100;");
            init.add("PERSONNAGE;12;AURA_WWWWWWWWWWWWW;Necromancer;100;");
            init.add("PERSONNAGE;13;CravingCoCnVaalTorture;Assassin;100;");
            init.add("PERSONNAGE;14;EchPowerPointSimulator;Ascendant;100;");
            init.add("PERSONNAGE;15;Daybit?TeamPoorjoys;Ascendant;100;");
            init.add("PERSONNAGE;16;CARRY_WWWWWWWWWWWW;Trickster;100;");
            init.add("PERSONNAGE;17;QbenTRR;Assassin;100;");
            init.add("PERSONNAGE;18;Mlnor;Assassin;100;");
            init.add("PERSONNAGE;19;Shrps;Deadeye;100;");
            init.add("PERSONNAGE;20;Falling_Ritual;Slayer;100;");

            try {
                facadeMetier.initialisation(init);
                estInitialise = true;
            } catch (BusinessException e) {
                facadeView.afficherMessageErreur(e.getMessage());
            }
        } else {
            this.facadeView.afficherMessage("L'initialisation a déjà été efféctuée.");
        }
    }
}
