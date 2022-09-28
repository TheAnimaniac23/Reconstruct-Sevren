package reconstruct.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.Rand;
import arc.util.Eachable;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.content.*;
import mindustry.entities.Effect;
import mindustry.entities.Lightning;
import mindustry.entities.UnitSorts;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.ContinuousFlameBulletType;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.*;
import mindustry.entities.units.BuildPlan;
import mindustry.gen.Bullet;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LaserTurret;
import mindustry.world.blocks.defense.turrets.PointDefenseTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.liquid.LiquidBridge;
import mindustry.world.blocks.liquid.LiquidRouter;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.SolidPump;
import mindustry.world.blocks.sandbox.ItemSource;
import mindustry.world.blocks.sandbox.LiquidSource;
import mindustry.world.blocks.sandbox.PowerVoid;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.consumers.ConsumeCoolant;
import mindustry.world.draw.*;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BuildVisibility;

public class SevrenBlocks {
    public static Block
        // distribution
        scrapConveyor, scrapJunction, scrapRouter, scrapBridge, goldConveyor, phaseBridge,
        phaseRouter, reforgedMassDriver, reforgedPayloadMassDriver, reforgedPayloadPropulsionTower,
        cobaltArmoredConveyor, thoriumConveyor, thoriumRouter, 

        // effect
        cobaltContainer, cobaltVault, cobaltUnloader, plasteelBuildTower, coreDebris, coreRemnant,
        coreFragment, regenerativeTurret, phaseShieldGenerator, overdriver, plasteelOverdriver,
        pulsewaveTower,

        // production
        goldRefinery, pyratiteMelder, plasteelBlastMixer, sandCrusher, graphiteInfuser, siliconFrostforge, 
        plasteelCrucible, phaseForge, slagMelter, cobaltExtractor, pyrokiln, meteorSling, cryofluidSynthesizer,
        surgeBlaster, cometSling,

        // fluid
        scrapConduit, scrapConduitJunction, scrapConduitRouter, goldFluidTank, cobaltFluidTank, 
        scrapConduitBridge, phaseConduitBridge, cobaltConduit, fluidPump, largeFluidPump, 

        // units
        scrapPayloadConveyor, scrapPayloadRouter, scrapPayloadBridge, scrapConstructor, massScrapConstructor,
        scrapDeconstructor, massScrapDeconstructor, scrapPayloadLoader, scrapPayloadUnloader, spiderUnitFactory, 
        hoverUnitFactory, boatUnitFactory, pointRefabricator, lineRefabricator, planeRefabricator, polygonRefebricator,

        // turrets
        scrappedDuo, scrapHail, lavaflowTurret, slagPropulsor, scrapTurret, reinforcedScrapTurret, voidedTurret,
        multiTurret, chargeTurret, anarchyTurret, neoplasiaMeteorTurret,

        // walls
        refinedScrapWall, largeRefinedScrapWall, goldWall, largeGoldWall, refinedScrapDoor, largeRefinedScrapDoor,
        autoRefinedScrapDoor, plasteelWall, largePlasteelWall, cobaltWall, largeCobaltWall, scrapSurgeWall, largeScrapSurgeWall,

        // power
        metaglassSolarPanel, largeMetaglassSolarPanel, phasePanel, largePhasePanel, fragmentedNeoplasiaReactor, 
        powerPropulsor, powerRouter, payloadPowerPropulsor, payloadPowerRouter,

        //drills
        mechanicalPumpDrill, hydrokineticDrill, thoriumDrill, blastDrill
        ;
    
    public static void load() {
        // distribution
        scrapConveyor = new Conveyor("scrap-conveyor"){{
            requirements(Category.distribution, with(Items.scrap, 1));
            health = 45;
            speed = 0.03f;
            displaySpeed = 4f;
            buildCostMultiplier = 2f;
        }};
        scrapJunction = new Junction("scrap-junction"){{
            requirements(Category.distribution, with(Items.scrap, 2));
            health = 45;
            speed = 0.03f;
            capacity = 6;
        }};
        scrapRouter = new Router("scrap-router"){{
            requirements(Category.distribution, with(Items.scrap, 3));
            health = 45;
        }};
        scrapBridge = new BufferedItemBridge("scrap-bridge"){{
            requirements(Category.distribution, with(RSItems.cobalt, 6, Items.scrap, 6));
            health = 45;
            fadeIn = moveArrows = false;
            range = 4;
            speed = 0.03f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
        }};
        goldConveyor = new Conveyor("gold-conveyor"){{
            requirements(Category.distribution, with(RSItems.gold, 2, Items.scrap, 1));
            health = 65;
            speed = 0.03f;
            displaySpeed = 12f;
        }};
        phaseBridge = new 
    }
}