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
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.power.Battery;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.PowerNode;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.SolidPump;
import mindustry.world.blocks.sandbox.ItemSource;
import mindustry.world.blocks.sandbox.LiquidSource;
import mindustry.world.blocks.sandbox.PowerVoid;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.blocks.payloads.*;
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
        goldRefinery, pyratiteMelder, plasteelBlastMixer, scrapCrusher, graphiteInfuser, siliconFrostforge, 
        plasteelCrucible, phaseForge, slagMelter, cobaltExtractor, pyrokiln, meteorSling, cryofluidSynthesizer,
        surgeBlaster, cometSling, hydroDeconstructor,

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
            size = 1;
            buildCostMultiplier = 2f;
        }};
        scrapJunction = new Junction("scrap-junction"){{
            requirements(Category.distribution, with(Items.scrap, 2));
            health = 45;
            speed = 0.03f;
            size = 1;
            capacity = 6;
        }};
        scrapRouter = new Router("scrap-router"){{
            requirements(Category.distribution, with(Items.scrap, 3));
            health = 45;
            size = 1;
        }};
        scrapBridge = new BufferedItemBridge("scrap-bridge"){{
            requirements(Category.distribution, with(RSItems.cobalt, 6, Items.scrap, 6));
            health = 45;
            fadeIn = moveArrows = false;
            size = 1;
            range = 4;
            speed = 0.03f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
        }};
        goldConveyor = new Conveyor("gold-conveyor"){{
            requirements(Category.distribution, with(RSItems.gold, 2, Items.scrap, 1));
            health = 65;
            size = 1;
            speed = 0.03f;
            displaySpeed = 12f;
        }};
        phaseBridge = new ItemBridge("phase-bridge"){{
            requirements(Category.distribution, with(RSItems.cobalt, 10, Items.graphite, Items.silicon, 7, Items.phaseFabric, 5));
            health = 80;
            range = 12;
            size = 1;
            arrowPeriod = 0.9f;
            arrowTimeSc1 = 2.75f;
            hasPower = true;
            pulse = true;
            envEnabled |= Env.space;
            consumePower(0.16f);
        }};
        // phaseRouter = new -- FINISH THIS
        reforgedMassDriver = new MassDriver("reforged-mass-driver"){{
            requirements(Category.distribution, with(RSItems.cobalt, 100, RSItems.gold, 60, Items.silicon, 75, Items.thorium, 50));
            health = 600;
            size = 3;
            itemCapacity = 120;
            range = 560f;
            reload = 200f;
            consumePower(0.96f);
        }};
        reforgedPayloadMassDriver = new PayloadMassDriver("reforged-payload-mass-driver"){{
            requirements(Category.distribution, with(Items.graphite, 60, Items.silicon, 80, RSItems.cobalt, 180, RSItems.gold, 40));
            size = 3;
            health = 900;
            maxPayloadSize = 2.5f;
            fogRadius = 5;
            regionSuffix = "-dark";
            range = 720f;
            reload = 130f;
            chargeTime = 90f;
            consumePower(1.2f);
        }};
        reforgedPayloadPropulsionTower = new PayloadMassDriver("reforged-payload-propulsion-tower"){{
            requirements(Category.distribution, with(Items.thorium, 300, Items.silicon, 200, RSItems.plasteel, 200, Items.phaseFabric, 40));
            size = 5;
            health = 1500;
            range = 1200f;
            maxPayloadSize = 3.5f;
            reload = 130f;
            chargeTime = 100f;
            regionSuffix = "-dark";
            consumePower(1.6f);
        }};
        cobaltArmoredConveyor = new ArmoredConveyor("cobalt-armored-conveyor"){{
            requirements(Category.distribution, with(RSItems.cobalt, 2, RSItems.gold, 2, Items.metaglass, 1));
            health = 120;
            size = 1;
            speed = 0.03f;
            displaySpeed = 12f;
        }};
        thoriumConveyor = new StackConveyor("thorium-conveyor"){{
            requirements(Category.distribution, with(Items.silicon, 1, Items.graphite, 1, Items.thorium, 3));
            health = 80;
            speed = 0.03f;
            size = 1;
            itemCapacity = 15;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;
            baseEfficiency = 1f;
            consumePower(0.16f);
        }};
        thoriumRouter = new StackRouter("thorium-router"){{
            requirements(Category.distribution, with(Items.silicon, 2, Items.graphite, 1, Items.thorium, 3));
            health = 80;
            speed = 0.03f;
            size = 1;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;
            baseEfficiency = 1f;
            solid = false;
            consumePower(0.16f);
        }};

        // effect
        cobaltContainer = new StorageBlock("cobalt-container"){{
            requirements(Category.effect, with(RSItems.cobalt, 100, Items.metaglass, 25));
            health = 150;
            size = 2;
            itemCapacity = 120;
        }};
        cobaltVault = new StorageBlock("cobalt-vault"){{
            requirements(Category.effect, with(RSItems.cobalt, 250, Items.thorium, 100, Items.metaglass, 50));
            health = 450;
            size = 3;
            itemCapacity = 500;
        }};
        cobaltUnloader = new Unloader("cobalt-unloader"){{
            requirements(Category.effect, with(Items.silicon, 30, RSItems.cobalt, 25));
            health = 80;
            size = 1;
            speed = 0.03f;
            group = BlockGroup.transportation;
        }};
        plasteelBuildTower = new BuildTurret("build-tower"){{
            requirements(Category.effect, with(Items.thorium, 60, Items.silicon, 150, RSItems.plasteel, 70));
            size = 3;
            outlineColor = Pal.darkOutline;
            range = 160f;
            buildSpeed = 1.5;
            consumePower(2.88f);
            consumesLiquid(Liquids.ozone, 3, Liquids.hydrogen, 2);
            health = 620;
        }};
        coreDebris = new CoreBlock("core-debris"){{
            requirements(Category.effect, with(Items.scrap, 900, RSItems.gold, 600));
            size = 2;
            alwaysUnlocked = true;
            isFirstTier = true;
            unitType = RSUnitTypes.byte;
            health = 400;
            unitCapModifier = 15;
            itemCapacity = 1000;
        }};
        coreRemnant = new CoreBlock("core-remnant"){{
            requirements(Category.effect, with(Items.scrap, 2500, RSItems.gold, 2500, Items.silicon, 1200));
            size = 3;
            unitType = RSUnitTypes.kilobyte;
            health = 1000;
            unitCapModifier = 25;
            itemCapacity = 2500;
        }};
        coreFragment = new CoreBlock("core-fragment"){{
            requirements(Category.effect, with(Items.scrap, 6000, RSItems.gold, 6000, Items.thorium, 2500, Items.silicon, 3000));
            size = 4;
            unitType = RSUnitTypes.megabyte;
            health = 3000;
            itemCapacity = 4000;
            unitCapModifier = 40;
        }};
        regenerativeTurret = new RepairTurret("regenerative-turret"){{
            requirements(Category.effect, with(Items.thorium, 70, RSItems.cobalt, 100, Items.silicon, 100, RSItems.plasteel, 70));
            size = 2;
            health = 300;
            powerUse = 0.4f;
            beamWidth = 1.1f;
            repairSpeed = 3f;
            repairRadius = 160f;
            pulseRadius = 6.1f;
            coolantUse = 0.16f;
            coolantMultiplier = 1.6f;
            acceptCoolant = true;
            length = 6f;
        }};
        phaseShieldGenerator = new ForceProjector("phase-shield-generator"){{
            requirements(Category.effect, with(Items.phaseFabric, 10, Items.scrap, 12, RSItems.gold, 16));
            health = 400;
            size = 2;
            phaseRadiusBoost = 80f;
            radius = 80f;
            cooldownNormal = 1.5f;
            shieldHealth = 800f;
            cooldownLiquid = 1f;
            cooldownBrokenBase = 0.3f;
            itemConsumer = consumeItems(Items.phaseFabric).boost();
            consumePower(3.2f);
        }};
        overdriver = new OverdriveProjector("overdriver"){{
            requirements(Category.effect, with(RSItems.gold, 100, RSItems.cobalt, 75, Items.silicon, 75, RSItems.plasteel, 30));
            health = 300;
            size = 2;
            range = 120f;
            speedBoost = 1.25f;
            useTime = 300f;
            hasBoost = false;
            consumeItems(RSItems.plasteel, 1).boost();
            consumePower(1.6f);
        }};
        plasteelOverdriver = new OverdriveProjector("plasteel-overdriver"){{
            requirements(Category.effect, with(RSItems.gold, 200, RSItems.cobalt, 130, Items.silicon, 130, RSItems.plasteel, 30, Items.surgeAlloy, 120));
            health = 500;
            size = 3;
            range = 240f;
            speedBoost = 2.25f;
            useTime = 300f;
            hasBoost = false;
            consumeItems(RSItems.plasteel, 1);
            consumeItems(Items.graphite, 1).boost();
            consumePower(3.2f);
        }};
        pulsewaveTower = new ShockwaveTower("pulsewave-tower"){{
            requirements(Category.effect, with(Items.silicon, 150, Items.surgeAlloy, 50, RSItems.cobalt, 150, RSItems.gold, 30));
            health = 700;
            size = 3;
            range = 280f;
            reload = 90f;
            bulletDamage = 160;
            falloffCount = 20f;
            shake = 4f;
            waveColor = Color.valueOf("ff2a04");
            consumePower(7.5f);
            consumeLiquids(LiquidStack.with(Liquids.hydrofluid, 4, Liquids.cryofluid, 2));
        }};

        // production
        goldRefinery = new GenericCrafter("gold-refinery"){{
            requirements(Category.crafting, with(Items.scrap, 20));
            outputItem = new ItemStack(RSItems.gold, 1);
            craftTime = 40f;
            size = 2;
            health = 250;
            hasPower = false;
            hasLiquids = false;
            consumeItems(with(Items.scrap, 1));
        }};
        pyratiteMelder = new GenericCrafter("pyratiteMelder"){{
            requirements(Category.crafting, with(RSItems.gold, 40, RSItems.cobalt, 25));
            outputItem = new ItemStack(Items.pyratite, 2);
            size = 2
            health = 200;
            hasPower = true;
            consumeItems(with(Item.sand, 2, Item.coal, 2, RSItems.cobalt, 1));
            consumePower(0.32f);
        }};
        plasteelBlastMixer = new GenericCrafter("plasteel-blast-mixer"){{
            requirements(Category.crafting, with(RSItems.cobalt, 25, RSItems.gold, 60, Items.thorium 40));
            outputItem = new ItemStack(Items.blastCompound, 2);
            size = 2;
            health = 400;
            hasPower = true;
            consumePower(0.8f);
            consumeItems(with(RSItems.plasteel, 3, Items.pyratite, 2, Items.coal, 3));
        }};
        scrapCrusher = new GenericCrafter("scrap-crusher"){{
            requirements(Category.crafting, with(Items.scrap, 20, RSItems.gold, 10));
            outputItem = new ItemStack(Items.sand, 1);
            size = 2;
            health = 200;
            hasPower = false;
            consumeItems(with(Items.scrap, 1));
        }};
        graphiteInfuser = new GenericCrafter("graphite-infuser"){{
            requirements(Category.crafting, with(Items.scrap, 20, RSItems.gold, 10));
            outputItem = new ItemStack(Items.graphite, 3);
            size = 3;
            health = 350;
            hasPower = false;
            consumeItems(with(Items.coal, 3));
        }};
        siliconFrostforge = new GenericCrafter("silicon-frostforge"){{
            requirements(Category.crafting, with(Items.scrap, 15, Items.graphite, 20, RSItems.gold, 10));
            outputItem = new ItemStack(Items.silicon, 2);
            size = 3;
            health = 400;
            hasPower = false;
            consumeItems(with(Items.coal, 1, Items.sand, 2));
        }};
        plasteelCrucible = new GenericCrafter("plasteel-crucible"){{
            requirements(Category.crafting, with(Items.thorium, 25, RSItems.gold, 30, RSItems.cobalt, 20));
            outputItem = new ItemStack(RSItems.plasteel, 2);
            size = 3;
            health = 500;
            liquidCapacity = 20f;
            consumeItems(with(Items.coal, 4, Items.cobalt, 2));
            consumeLiquids(LiquidStack.with(Liquids.ozone, 4.5f, Liquids.hydrogen, 2));
            consumePower(3.2f);
        }};
        phaseForge = new GenericCrafter("phase-forge"){{
            requirements(Category.crafting, with(Items.thorium, 45, Items.silicon, 100, RSItems.cobalt, 200));
            outputItem = new ItemStack(Items.phaseFabric, 1);
            health = 300;
            size = 2;
            consumeItems(with(Items.thorium, 4, Items.sand, 10));
            consumePower(0.48f);
        }};
        slagMelter = new GenericCrafter("slag-melter"){{
            requirements(Category.crafting, with(Items.scrap, 10, RSItems.gold, 15));
            outputLiquid = new LiquidStack(Liquids.slag, 1.5f);
            health = 100;
            size = 1;
            consumeItems(with(Items.scrap, 1));
        }};
        cobaltExtractor = new GenericCrafter("cobalt-extractor"){{
            requirements(Category.crafting, with(Items.scrap, 20, Items.graphite, 10, RSItems.gold, 10));
            outputItem = new ItemStack(RSItems.cobalt, 1);
            health = 500;
            size = 2;
            consumeLiquids(LiquidStack.with(Liquids.slag, 1.5f));
        }};
        pyrokiln = new GenericCrafter("pyrokiln"){{
            requirements(Category.crafting, with(Items.scrap, 10, Items.coal, 10, RSItems.cobalt, 15));
            outputItem = new ItemStack(Items.metaglass, 1);
            health = 210;
            size = 2;
            consumeItems(with(Items.sand, 1, Items.coal, 2));
        }};
        // meteorSling = new RSGravityMine("meteor-sling"){{}} -- NEEDS FINISHED
        // cometSling = new RSGravityMine("comet-sling"){{}} -- NEEDS FINISHED
        cryofluidSynthesizer = new GenericCrafter("cryofluid-synthesizer"){{
            requirements(Category.crafting, with(Items.silicon, 30, RSItems.cobalt, 30, RSItems.gold, 15));
            outputLiquid = new LiquidStack(Liquids.cryofluid, 1.5f);
            health = 920;
            size = 3;
            consumeItems(with(RSItems.cobalt, 1));
            consumeLiquids(LiquidStack.with(Liquids.water, 1.5f));
            consumePower(0.8f);
        }};
        surgeBlaster = new GenericCrafter("surge-blaster"){{
            requirements(Category.crafting, with(RSItems.plasteel, 80, Items.graphite, 100, Items.silicon, 100, RSItems.cobalt, 150));
            health = 700;
            size = 3;
            consumeItems(with(Items.blastCompound, 15, Items.silicon, 5));
            consumeLiquids(LiquidStack.with(Liquids.hydrogen, 3f, Liquids.slag, 10f));
            consumePower(3.2f);
        }};
        hydroDeconstructor = new GenericCrafter("hydro-deconstructor"){{
            requirements(Category.crafting, with(RSItems.gold, 15, RSItems.cobalt, 20));
            outputLiquid = new LiquidStack(Liquids.hydrogen, 1f, Liquids.Ozone, 0.5f);
            health = 300;
            size = 2;
            consumesLiquid(LiquidStack.with(Liquids.water, 1.5f));
        }};

        // fluids
        scrapConduit = new Conduit("scrap-conduit"){{
            requirements(Category.liquid, with(Items.scrap, 1, Items.metaglass, 1));
            health = 45;
            size = 1;
            liquidCapacity = 5f;
            liquidPressure = 1f;
        }};
        scrapConduitJunction = new LiquidJunction("scrap-conduit-function"){{
            requirements(Category.liquid, with(Items.metaglass, 8, Items.scrap, 4, Items.graphite, 4));
            health = 50;
            size = 1;
            liquidCapacity = 10f;
            liquidPressure = 1.5f;
        }};
        scrapConduitRouter = new LiquidRouter("scrap-conduit-router"){{
            requirements(Category.liquid, with(Items.scrap, 6, Items.graphite, 8));
            health = 50;
            size = 1;
            liquidCapacity = 20f;
            liquidPressure = 1.5f;
        }};
        goldFluidTank = new LiquidRouter("gold-fluid-tank"){{
            requirements(Category.liquid, with(Items.scrap, 20, RSItems.gold, 16));
            health = 300;
            liquidCapacity = 800f;
            size = 2;
            liquidPressure = 2f;
        }};
        cobaltFluidTank = new LiquidRouter("cobalt-fluid-tank"){{
            requirements(Category.liquid, with(RSItems.cobalt, 50, RSItems.gold, 40));
            health = 700;
            liquidCapacity = 1800f;
            size = 3;
            liquidPressure = 2f;
        }};
        scrapConduitBridge = new LiquidBridge("scrap-conduit-bridge"){{
            requirements(Category.liquid, with(Items.metaglass, 8, Items.scrap, 4, Items.graphite, 4));
            health = 100;
            fadeIn = moveArrows = false;
            size = 1;
            range = 4;
            arrowSpacing = 6f;
        }};
        phaseConduitBridge = new LiquidBridge("phase-conduit-bridge"){{
            requirements(Category.liquid, with(Items.phaseFabric, 5, RSItems.cobalt, 10, RSItems.gold, 5));
            health = 120;
            size = 1;
            range = 12;
            arrowPeriod = 0.9f;
            arrowTimeSc1 = 2.75f;
            hasPower = true;
            canOverdrive = true;
            pulse = true;
            consumePower(0.3f);
        }};
        cobaltConduit = new Conduit("cobalt-conduit"){{
            requirements(Category.liquid, with(Items.scrap, 1, Items.metaglass, 1));
            health = 100;
            size = 1;
            liquidCapacity = 16f;
            liquidPressure = 1.25f;
        }};
        fluidPump = new Pump("fluid-pump"){{
            requirements(Category.liquid, with(Items.scrap, 15, Items.metaglass, 20));
            health = 20;
            size = 1;
            pumpAmmount = 0.5f;
            hasPower = false;
            liquidCapacity = 20f;
        }};
        largeFluidPump = new Pump('large-fluid-pump'){{
            requirements(Category.liquid, with(RSItems.gold, 20, Items.metaglass, 30));
            health = 100;
            size = 2;
            pumpAmmount = 1.5f;
            hasPower = true;
            liquidCapacity = 50f;
            consumePower = 0.1f;
        }};

        // units
        scrapPayloadConveyor = new PayloadConveyor("scrap-payload-conveyor"){{
            requirements(Category.units, with(Items.scrap, 15, Items.graphite, 5));
            moveTime = 45f;
            size = 3;
            health = 350;
        }}
        scrapPayloadRouter = new PayloadRouter("scrap-payload-router"){{
            requirements(Category.units, with(Items.scrap, 15, Items.graphite, 5));
            moveTime = 45f;
            size = 3;
            health = 350;
        }}
        // scrapPayloadBridge = new PayloadBridge("scrap-payload-bridge"){{}} -- NEEDS FINISHED;
        scrapConstructor = Constructor("scrap-constructor"){{
            requirements(Category.units, with(Items.scrap, 120, RSItems.gold, 60, Items.silicon, 100));
            regionSuffix = "-dark";
            hasPower = true;
            buildSpeed = 0.3f;
            consumePower(1.92f);
            size = 3;
            filter = Seq.with(RSBlocks.cobaltContainer, RSBlocks.largeRefinedScrapWall, RSBlocks.largeGoldWall, RSBlocks.largePlasteelWall, RSBlocks.largeScrapSurgeWall, RSBlocks.goldFluidTank);
        }};
        massScrapConstructor = new Constructor("mass-scrap-constructor"){{
            requirements(Category.units,with(Items.silicon, 150, Items.phaseFabric, 45, RSItems.cobalt, 200, RSItems.plasteel, 150));
            regionSuffix = "-dark";
            hasPower = true;
            buildSpeed = 0.3f;
            consumePower(3.2f);
            size = 5;
            filter = Seq.with(RSBlocks.cobaltContainer, RSBlocks.largeRefinedScrapWall, RSBlocks.largeGoldWall, RSBlocks.largePlasteelWall, RSBlocks.largeScrapSurgeWall, RSBlocks.goldFluidTank, RSBlocks.cobaltFluidTank, RSBlocks.cobaltVault);
        }};
        scrapDeconstructor
        massScrapDeconstructor
        scrapPayloadLoader
        scrapPayloadUnloader
        spiderUnitFactory
        hoverUnitFactory
        boatUnitFactory
        pointRefabricator
        lineRefabricator
        planeRefabricator
        polygonRefebricator

    }
}