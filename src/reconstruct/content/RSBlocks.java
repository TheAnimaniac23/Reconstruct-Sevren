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
    import mindustry.entities.*;
    import mindustry.entities.abilities.*;
    import mindustry.entities.bullet.*;
    import mindustry.entities.comp.*;
    import mindustry.entities.effect.*;
    import mindustry.entities.part.*;
    import mindustry.entities.pattern.*;
    import mindustry.entities.units.*;
    import mindustry.world.blocks.campaign.*;
    import mindustry.world.blocks.defense.*;
    import mindustry.world.blocks.defense.turrets.*;
    import mindustry.world.blocks.distribution.*;
    import mindustry.world.blocks.enviroment.*;
    import mindustry.world.blocks.heat.*;
    import mindustry.world.blocks.legacy.*;
    import mindustry.world.blocks.liquid.*;
    import mindustry.world.blocks.logic.*;
    import mindustry.world.blocks.payloads.*;
    import mindustry.world.blocks.power.*;
    import mindustry.world.blocks.production.*;
    import mindustry.world.blocks.sandbox.*;
    import mindustry.world.blocks.storage.*;
    import mindustry.world.blocks.units.*;
    import mindustry.world.consumers.*;
    import mindustry.world.draw.*;
    import mindustry.world.meta.*;
    import mindustry.world.modules.*;
    
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
            size = 2;
            health = 200;
            hasPower = true;
            consumeItems(with(Item.sand, 2, Item.coal, 2, RSItems.cobalt, 1));
            consumePower(0.32f);
        }};
        plasteelBlastMixer = new GenericCrafter("plasteel-blast-mixer"){{
            requirements(Category.crafting, with(RSItems.cobalt, 25, RSItems.gold, 60, Items.thorium, 40));
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
        largeFluidPump = new Pump("large-fluid-pump"){{
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
        }};
        scrapPayloadRouter = new PayloadRouter("scrap-payload-router"){{
            requirements(Category.units, with(Items.scrap, 15, Items.graphite, 5));
            moveTime = 45f;
            size = 3;
            health = 350;
        }};
        // scrapPayloadBridge = new PayloadBridge("scrap-payload-bridge"){{}} -- NEEDS FINISHED
        scrapConstructor = Constructor("scrap-constructor"){{
            requirements(Category.units, with(Items.scrap, 120, RSItems.gold, 60, Items.silicon, 100));
            regionSuffix = "-dark";
            health = 800;
            itemCapacity = 150;
            hasPower = true;
            buildSpeed = 0.3f;
            consumePower(1.92f);
            size = 3;
            filter = Seq.with(RSBlocks.cobaltContainer, RSBlocks.largeRefinedScrapWall, RSBlocks.largeGoldWall, RSBlocks.largePlasteelWall, RSBlocks.largeScrapSurgeWall, RSBlocks.goldFluidTank);
        }};
        massScrapConstructor = new Constructor("mass-scrap-constructor"){{
            requirements(Category.units,with(Items.silicon, 150, Items.phaseFabric, 45, RSItems.cobalt, 200, RSItems.plasteel, 150));
            regionSuffix = "-dark";
            health = 1200;
            hasPower = true;
            buildSpeed = 0.3f;
            consumePower(3.2f);
            size = 5;
            filter = Seq.with(RSBlocks.cobaltContainer, RSBlocks.largeRefinedScrapWall, RSBlocks.largeGoldWall, RSBlocks.largePlasteelWall, RSBlocks.largeScrapSurgeWall, RSBlocks.goldFluidTank, RSBlocks.cobaltFluidTank, RSBlocks.cobaltVault);
        }};
        scrapDeconstructor = new PayloadDeconstructor("scrap-deconstructor"){{
            requirements(Category.units, with(Items.silicon, 100, Items.scrap, 120, RSItems.gold, 60));
            regionSuffix = "-dark";
            health = 800;
            itemCapacity = 150;
            consumePower(1.92f);
            size = 3;
            deconstructSpeed = 1f;
        }};
        massScrapDeconstructor = new PayloadDeconstructor("mass-scrap-deconstructor"){{
            requirements(Category.units, with(Items.silicon, 150, Items.phaseFabric, 45, RSItems.cobalt, 200, RSItems.plasteel, 150));
            regionSuffix = "-dark";
            health = 1200;
            itemCapacity = 300;
            consumePower(3.2f);
            size = 5;
            deconstructSpeed = 2f;
        }};
        scrapPayloadLoader = new PayloadLoader("scrap-payload-loader"){{
            requirements(Category.units, with(Items.graphite, 50, Items.silicon, 50, RSItems.cobalt, 80));
            regionSuffix = "-dark";
            health = 680;
            itemCapacity = 100;
            liquidCapacity = 100f;
            consumePower(1.6f);
                size = 3;
            }};
            scrapPayloadUnloader = new PayloadUnloader("scrap-payload-unloader"){{
                requirements(Category.units, with(Items.graphite, 50, Items.silicon, 50, RSItems.cobalt, 30));
                regionSuffix = "-dark";
                health = 680;
                size = 3;
                itemCapacity = 100;
                liquidCapacity = 100f;
                consumePower(1.6f);
            }};
            spiderUnitFactory = new UnitFactory("spider-unit-factory"){{
            requirements(Category.units, with(Items.scrap, 50, RSItems.gold, 100, Items.silicon, 80));
            plans = Seq.with(
                new UnitPlan(RSUnitTypes.rain, 60f * 10f, with(Items.silicon, 10, RSItems.cobalt, 5)),
                new UnitPlan(RSUnitTypes.SSupT1, 60f * 20f, with(RSItems.cobalt, 10, Items.silicon, 15, RSItems.gold, 5)),
                new UnitPlan(UnitTypes.crawler, 60f * 15f, with(Items.silicon, 15, Items.coal, 10, RSItems.cobalt, 5))
                );
                size = 3;
                health = 350;
                consumePower(1.12);
            }};
            hoverUnitFactory = new UnitFactory("hover-unit-factory"){{
                requirements(Category.units, with(Items.scrap, 60, RSItems.gold, 150));
                plans = Seq.with(
                    new UnitPlan(RSUnitTypes.frost, 60f * 25f, with(Items.silicon, 20)),
                    new UnitPlan(RSUnitTypes.HSupT1, 60f * 15f, with(Items.silicon, 20, RSItems.gold, 15)),
                    new UnitPlan(RSUnitTypes.HSpeT1, 60f * 10f, with(Items.silicon, 30, RSItems.cobalt, 15))
                );
                size = 3;
                health = 350;
                consumePower(1.12f);
            }};
        boatUnitFactory = new UnitFactory("boat-unit-factory"){{
            requirements(Category.units, with(Items.scrap, 160, RSItems.cobalt, 120, Items.metaglass, 100));
            plans = Seq.with(
                new UnitPlan(RSUnitTypes.gale, 60f * 12f, with(Items.silicon, 20, Items.metaglass, 30)),
                new UnitPlan(RSUnitTypes.BSupT1, 60f * 20f, with(Items.silicon, 15, Items.metaglass, 20, RSItems.cobalt, 10)),
                new UnitPlan(RSUnitTypes.BSpeT1, 60f * 10f, with(Items.silicon, 20, Items.metaglass, 15, Items.coal, 30))
            );
            size = 3;
            health = 350;
            consumePower(1.12f);
        }};
        pointRefabricator = new Reconstructor("point-refabricator"){{
            requirements(Category.units, with(RSItems.gold, 200, RSItems.cobalt, 150, Items.silicon, 80));
            size = 3;
            health = 350;
            consumePower(1.6f);
            consumeItems(with(Items.silicon, 30, Items.metaglass, 15));
            constructTime = 60f * 40f;
            upgrades.addAll (
                new UnitType[]{RSUnitTypes.rain, RSUnitTypes.storm},
                new UnitType[]{RSUnitTypes.SSupT1, RSUnitTypes.SSupT2},
                new UnitType[]{UnitTypes.crawler, UnitTypes.atrax},
                new UnitType[]{RSUnitTypes.frost, RSUnitTypes.hail},
                new UnitType[]{RSUnitTypes.HSupT1, RSUnitTypes.HSupT2},
                new UnitType[]{RSUnitTypes.HSpeT1, RSUnitTypes.HSpeT2},
                new UnitType[]{RSUnitTypes.gale, RSUnitTypes.furor},
                new UnitType[]{RSUnitTypes.BSupT1, RSUnitTypes.BSupT2},
                new UnitType[]{RSUnitTypes.BSpeT1, RSUnitTypes.BSpeT2}
            );
        }};
        lineRefabricator = new Reconstructor("line-refabricator"){{
            requirements(Category.units, with(RSItems.gold, 600, RSItems.cobalt, 300, Items.thorium, 500, Items.silicon, 400));
            size = 5;
            health = 900;
            consumePower(2.08f);
            consumeItems(with(Items.silicon, 50, Items.metaglass, 35));
            constructTime = 60f * 55f;
            upgrades.addAll (
                new UnitType[]{RSUnitTypes.storm, RSUnitTypes.whirlwind},
                new UnitType[]{RSUnitTypes.SSupT2, RSUnitTypes.SSupT3},
                new UnitType[]{UnitTypes.atrax, UnitTypes.spiroct},
                new UnitType[]{RSUnitTypes.hail, RSUnitTypes.ice},
                new UnitType[]{RSUnitTypes.HSupT2, RSUnitTypes.HSupT3},
                new UnitType[]{RSUnitTypes.HSpeT2, RSUnitTypes.HSpeT3},
                new UnitType[]{RSUnitTypes.furor, RSUnitTypes.squall},
                new UnitType[]{RSUnitTypes.BSupT2, RSUnitTypes.BSupT3},
                new UnitType[]{RSUnitTypes.BSpeT2, RSUnitTypes.BSpeT3}
            );
        }};
        planeRefabricator = new Reconstructor("plane-refabricator"){{
            requirements(Category.units, with(RSItems.gold, 2000, RSItems.cobalt, 1500, Items.thorium, 350, Items.silicon, 1200, RSItems.plasteel, 400, Items.phaseFabric, 300));
            size = 7;
            health = 1200;
            consumePower(3.2f);
            consumeItems(with(Items.silicon, 100, Items.metaglass, 80, Items.thorium, 40));
            consumeLiquids(LiquidStack.with(Liquids.cryofluid, 9.5f));
            constructTime = 60f * 125f;
            upgrades.addAll (
                new UnitType[]{RSUnitTypes.whirlwind, RSUnitTypes.typhoon},
                new UnitType[]{RSUnitTypes.SSupT3, RSUnitTypes.SSupT4},
                new UnitType[]{UnitTypes.spiroct, UnitTypes.arkyid},
                new UnitType[]{RSUnitTypes.ice, RSUnitTypes.glacier},
                new UnitType[]{RSUnitTypes.HSupT3, RSUnitTypes.HSupT4},
                new UnitType[]{RSUnitTypes.HSpeT3, RSUnitTypes.HSpeT4},
                new UnitType[]{RSUnitTypes.squall, RSUnitTypes.turmoil},
                new UnitType[]{RSUnitTypes.BSupT3, RSUnitTypes.BSupT4},
                new UnitType[]{RSUnitTypes.BSpeT3, RSUnitTypes.BSpeT4}
            );
        }};
        polygonRefebricator = new Reconstructor("polygon-refabricator"){{
            requirements(Category.units, with(RSItems.gold, 3000, Items.thorium, 750, Items.silicon, 2000, RSItems.plasteel, 600, Items.phaseFabric, 300, Items.surgeAlloy, 600));
            size = 9;
            health = 1900;
            consumePower(4.48f);
            consumeItems(with(Items.silicon, 140, Items.metaglass, 100, Items.thorium, 90));
            consumeLiquids(LiquidStack.with(Liquids.cryofluid, 14f));
            upgrades.addAll (
                new UnitType[]{RSUnitTypes.typhoon, RSUnitTypes.hurricane},
                new UnitType[]{RSUnitTypes.SSupT4, RSUnitTypes.SSupT5},
                new UnitType[]{UnitTypes.arkyid, UnitTypes.toxopid},
                new UnitType[]{RSUnitTypes.glacier, RSUnitTypes.permafrost},
                new UnitType[]{RSUnitTypes.HSupT4, RSUnitTypes.HSupT5},
                new UnitType[]{RSUnitTypes.HSpeT4, RSUnitTypes.HSpeT5},
                new UnitType[]{RSUnitTypes.turmoil, RSUnitTypes.tempest},
                new UnitType[]{RSUnitTypes.BSupT4, RSUnitTypes.BSupT5},
                new UnitType[]{RSUnitTypes.BSpeT4, RSUnitTypes.BSpeT5}
            );
        }};
    
        // turrets
        scrappedDuo = new ItemTurret("scrapped-duo"){{
            requirements(Category.turrets, with(Items.scrap, 35));
            ammo (
                Items.scrap, new BasicBulletType(2.5f, 4){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                    ammoMultiplier = 2;
                }}
            );
            shoot = new ShootAlternate(3.5f);
            shootY = 3f;
            reload = 20f;
            range = 104;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            size = 1;
            inaccuracy = 2f;
            rotateSpeed = 10f;
            coolant = ConsumeCoolant(0.1f);
            limitRange();
        }};
        scrapHail = new ItemTurret("scrap-hail"){{
            requirements(Category.turrets, with(Items.scrap, 40, Items.graphite, 15));
            ammo (
                Items.graphite, new ArtilleryBulletType(3f, 7){{
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 11f;
                    collidesTiles = false;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 33f;
                }},
                Items.silicon, new ArtilleryBulletType(3f, 10){{
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 11f;
                    collidesTiles = false;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 33f;
                    reloadMultiplier = 1.2f;
                    ammoMultiplier = 3f;
                    homingPower = 0.08f;
                    homingRange = 50f;
                }},
                Items.pyratite, new ArtilleryBulletType(3f, 10){{
                    hitEffect = Fx.blastExplosion;
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 13f;
                    collidesTiles = false;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 45f;
                    status = StatusEffects.burning;
                    statusDuration = 60f * 12f;
                    frontColor = Pal.lightishOrange;
                    backColor = Pal.lightOrange;
                    makeFire = true;
                    trailEffect = Fx.incendTrail;
                    ammoMultiplier = 4f;
                }}
            );
            targetAir = false;
            reload = 60f;
            recoil = 2f;
            range = 240f;
            inaccuracy = 1f;
            shootCone = 10f;
            health = 250;
            size = 1;
            shootSound = Sounds.bang;
            coolant = consumeCoolant(0.1f);
            limitRange(0f);
        }};
        lavaflowTurret = new LiquidTurret("lavaflow-turret"){{
            requirements(Category.turrets, with(Items.metaglass, 100, RSItems.gold, 400, RSItems.cobalt, 250, Items.thorium, 100));
            ammo (
                Liquids.slag, new LiquidBulletType(Liquids.slag){{
                    lifetime = 50f;
                    speed = 5f;
                    knockback = 1.5f;
                    puddleSize = 15f;
                    orbSize = 7.5f;
                    drag = 0.001f;
                    ammoMultiplier = 0.5f;
                    statusDuration = 60f * 4f;
                    damage = 10;
                }}
            );
            size = 3;
            reload = 4f;
            shoot.shots = 3;
            velocityRnd = 0.1f;
            inaccuracy = 4.5f;
            recoil = 0.25f;
            shootCone = 50f;
            liquidCapacity = 100f; 
            shootEffect = Fx.shootLiquid;
            range = 280f;
            health = 350;
        }};
        slagPropulsor = new LiquidTurret("slag-propulsor"){{
            requirements(Category.turrets, with(RSItems.cobalt, 300, RSItems.gold, 75, Items.metaglass, 100));
            ammo (
                Liquids.slag, new LiquidBulletType(Liquids.slag){{
                    lifetime = 150f;
                    speed = 15f;
                    knockback = 1.5f;
                    puddleSize = 15f;
                    orbSize = 7.5f;
                    drag = 0.001f;
                    ammoMultiplier = 1.5f;
                    statusDuration = 60f * 8f;
                    damage = 15;
                }},
                Liquids.neoplasm, new LiquidBulletType(Liquids.neoplasm){{
                    lifetime = 150f;
                    speed = 15f;
                    knockback = 2.5f;
                    puddleSize = 15f;
                    orbSize = 7.5f;
                    drag = 0.001f;
                    ammoMultiplier = 0.5f;
                    statusDuration = 60f * 12f;
                    damage = 35;
                }}
            );
            size = 4;
            reload = 3f;
            shoot.shots = 7;
            velocityRnd = 0.1f;
            inaccuracy = 0.1f;
            recoil = 1f;
            shootCone = 25f;
            liquidCapacity = 250f;
            shootEffect = Fx.shootLiquid;
            range = 450f;
            health = 600;
        }};
        scrapTurret = new ItemTurret("scrap-turret"){{
            requirements(Category.turrets, with(Items.scrap, 85, RSItems.gold, 50));
            ammo (
                Items.scrap, new BasicBulletType(7.5f, 7){{
                    lifetime = 250f;
                    speed = 5.5f;
                    knockback = 0.05f;
                    collidesTiles = false;
                    width = 5f;
                    height = 7f;
                    ammoMultiplier = 3;
                }},
                RSItems.gold, new ArtilleryBulletType(7.5f, 15){{
                    knockback = 0.8f;
                    lifetime = 80f;
                    width = height = 11f;
                    collidesTiles = false;
                    splashDamageRadius = 25f * 0.75f;
                    splashDamage = 33f;
                }}
            );
            
        }}
        reinforcedScrapTurret
        voidedTurret
        multiTurret
        chargeTurret
        anarchyTurret
        // neoplasiaMeteorTurret = new MeteorTurret("neoplasia-meteor-turret"){{}} -- NEEDS FINISHED
    }
    }