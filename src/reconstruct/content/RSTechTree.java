import reconstruct.content;

import arc.struct.*;
import mindustry.game.Objectives.*;

import static mindustry.content.blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.SectorPresets.craters;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class SevrenTechTree {
    public static void load() {
        Planets.sevren.techtree = nodeRoot("sevren", RSBlocks.coreDebris, () -> {
            node(RSBlocks.scrapConveyor, () -> {
                node(RSBlocks.scrapJunction, () -> {
                    node(RSBlocks.scrapRouter, () -> {
                        node(RSBlocks.cobaltContainer, () -> {
                            node(RSBlocks.cobaltVault, () -> {

                            });
                            node(RSBlocks.cobaltUnloader, () -> {

                            });
                        });
                        node(RSBlocks.scrapBridge, () -> {
                            node(RSBlocks.goldConveyor, () -> {
                                node(RSBlocks.phaseBridge, () -> {
                                    node(RSBlocks.phaseRouter, () -> {
                                        node(RSBlocks.reforgedMassDriver, () -> {
                                            node(RSBlocks.reforgedPayloadMassDriver, () -> {
                                                node(RSBlocks.reforgedPayloadPropulsionTower, () -> {

                                                });
                                            });
                                            node(RSBlocks.plasteelBuildTower, () -> {

                                            });
                                        });
                                    });
                                });
                                node(RSBlocks.scrapPayloadConveyor, () -> {
                                    node(RSBlocks.scrapPayloadRouter, () -> {
                                        node(RSBlocks.scrapPayloadBridge, () -> {

                                        });
                                    });
                                });
                                node(RSBlocks.cobaltArmoredConveyor, () -> {
                                    node(RSBlocks.thoriumConveyor, () -> {
                                        node(RSBlocks.thoriumRouter, () -> {

                                        });
                                    });
                                });
                                node(RSBlocks.scrapConstructor, () ->  {
                                    node(RSBlocks.scrapPayloadLoader, () -> {
                                        node(RSBlocks.scrapPayloadUnloader, () -> {

                                        });
                                    });
                                    node(RSBlocks.scrapDeconstructor, () -> {
                                        node(RSBlocks.massScrapDeconstructor, () -> {

                                        });
                                    });
                                    node(RSBlocks.massScrapConstructor, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(RSBlocks.coreRemnant, () -> {
                node(RSBlocks.coreFragment, () -> {

                });
            });
            node(RSBlocks.mechanicalPumpDrill, () -> {
                node(RSBlocks.cometSling, () -> {
                    node(RSBlocks.scrapConduit, () -> {
                        node(RSBlocks.scrapConduitJunction, () -> {
                            node(RSBlocks.scrapConduitRouter, () -> {
                                node(RSBlocks.goldFluidTank, () -> {
                                    node(RSBlocks.cobaltFluidTank, () -> {

                                    });
                                });
                                node(RSBlocks.scrapConduitBridge, () -> {
                                    node(RSBlocks.phaseConduitBridge, () -> {

                                    });
                                });
                                node(RSBlocks.cobaltConduit, () -> {

                                });
                                node(RSBlocks.fluidPump, () -> {
                                    node(RSBlocks.largeFluidPump, () -> {

                                    });
                                });
                            });
                        });
                        node(RSBlocks.hydroDeconstructor, () -> {
                            
                        });
                    });
                });
                node(RSBlocks.goldRefinery, () -> {
                    node(RSBlocks.hydrokineticDrill, () -> {
                        node(RSBlocks.thoriumDrill, () -> {
                            node(RSBlocks.blastDrill, () -> {

                            });
                        });
                    });
                    node(RSBlocks.pyratiteMelder, () -> {
                        node(RSBlocks.plasteelBlastMixer, () -> {

                        });
                    });
                    node(RSBlocks.scrapCrusher, () -> {
                        node(RSBlocks.graphiteInfuser, () -> {
                            node(RSBlocks.siliconFrostforge, () -> {
                                node(RSBlocks.plasteelCrucible, () -> {
                                    node(RSBlocks.phaseForge, () -> {

                                    });
                                });
                            });
                        });
                        node(RSBlocks.slagMelter, () -> {
                            node(RSBlocks.cobaltExtractor, () -> {
                                node(RSBlocks.pyrokiln, () -> {

                                });
                                node(RSBlocks.meteorSling, () -> {
                                    node(RSBlocks.cryofluidSynthesizer, () -> {

                                    });
                                    node(RSBlocks.surgeBlaster, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
                node(RSBlocks.metaglassSolarPanel, () -> {
                    node(RSBlocks.powerPropulsor, () -> {
                        node(RSBlocks.powerRouter, () -> {
                            node(RSBlocks.payloadPowerPropulsor, () -> {
                                node(RSBlocks.payloadPowerRouter, () -> {
                                    
                                });
                            });
                        });
                        node(RSBlocks.regenerativeTurret, () -> {
                            node(RSBlocks.phaseShieldGenerator, () -> {
                                node(RSBlocks.overdriver, () -> {
                                    node(RSBlocks.plasteelOverdriver, () -> {
                                        node(RSBlocks.pulsewaveTower, () -> {

                                        });
                                    });
                                });
                            });
                        });
                        node(RSBlocks.largeMetaglassSolarPanel, () -> {
                            node(RSBlocks.phasePanel, () -> {
                                node(RSBlocks.largePhasePanel, () -> {
                                    node(RSBlocks.fragmentedNeoplasiaReactor, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
        node(RSBlocks.scrappedDuo, () -> {
            node(RSBlocks.refinedScrapWall, () -> {
                node(RSBlocks.largeRefinedScrapWall, () -> {
                    node(RSBlocks.goldWall, () -> {
                        node(RSBlocks.largeGoldWall, () -> {

                        });
                        node(RSBlocks.refinedScrapDoor, () -> {
                            node(RSBlocks.largeRefinedScrapDoor, () -> {
                                node(RSBlocks.autoRefinedScrapDoor, () -> {

                                });
                            });
                        });
                        node(RSBlocks.plasteelWall, () -> {
                            node(RSBlocks.largePlasteelWall, () -> {

                            });
                        });
                        node(RSBlocks.cobaltWall, () -> {
                            node(RSBlocks.largeCobaltWall, () -> {

                            });
                            node(RSBlocks.scrapSurgeWall, () -> {
                                node(RSBlocks.largeScrapSurgeWall, () -> {

                                });
                            });
                        });
                    });
                });
            });
            node(RSBlocks.scrapHail, () -> {
                node(RSBlocks.lavaflowTurret, () -> {
                    node(RSBlocks.slagPropulsor, () -> {

                    });
                });
            });
            node(RSBlocks.scrapTurret, () -> {
                node(RSBlocks.reinforcedScrapTurret, () -> {
                    node(RSBlocks.voidedTurret, () -> {
                        node(RSBlocks.multiTurret, () -> {
                            node(RSBlocks.chargeTurret, () -> {
                                node(RSBlocks.anarchyTurret, () -> {
                                    node(RSBlocks.neoplasiaMeteorTurret, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
        node(RSBlocks.spiderUnitFactory, () -> {
            node(rain, () -> {
                node(storm, () -> {
                    node(whirlwind, () -> {
                        node(typhoon, () -> {
                            node(hurricane, () -> {

                            });
                        });
                    });
                });
                node(SSupT1, () -> {
                    node(SSupT2, () -> {
                        node(SSupT3, () -> {
                            node(SSupT4, () -> {
                                node(SSupT5, () -> {
                                    
                                });
                            });
                        });
                    });
                });
                node(SSpeT1, () -> {
                    node(SSpeT2, () -> {
                        node(SSpeT3, () -> {
                            node(SSpeT4, () -> {
                                node(SSpeT5, () -> {

                                });
                            });
                        });
                    });
                });
            });
            node(RSBlocks.hoverUnitFactory, () -> {
                node(frost, () -> {
                    node(hail, () -> {
                        node(ice, () -> {
                            node(glacier, () -> {
                                node(permafrost, () -> {

                                });
                            });
                        });
                    });
                    node(HSupT1, () -> {
                        node(HSupT2, () -> {
                            node(HSupT3, () -> {
                                node(HSupT4, () -> {
                                    node(HSupT5, () -> {
                                        
                                    });
                                });
                            });
                        });
                    });
                    node(HSpeT1, () -> {
                        node(HSpeT2, () -> {
                            node(HSpeT3, () -> {
                                node(HSpeT4, () -> {
                                    node(HSpeT5, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
                node(RSBlocks.boatUnitFactory, () -> {
                    node(gale, () -> {
                        node(furor, () -> {
                            node(squall, () -> {
                                node(turmoil, () -> {
                                    node(tempest, () -> {

                                    });
                                });
                            });
                        });
                        node(BSupT1, () -> {
                            node(BSupT2, () -> {
                                node(BSupT3, () -> {
                                    node(BSupT4, () -> {
                                        node(BSupT5, () -> {

                                        });
                                    });
                                });
                            });
                        });
                        node(BSpeT1, () -> {
                            node(BSpeT2, () -> {
                                node(BSpeT3, () -> {
                                    node(BSpeT4, () -> {
                                        node(BSpeT5, () -> {

                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(RSBlocks.pointRefabricator, () -> {
                node(RSBlocks.lineRefabricator, () -> {
                    node(RSBlocks.planeRefabricator, () -> {
                        node(RSBlocks.polygonRefabricator, () -> {

                        });
                    });
                });
            });
        });
        node(ruin, () -> {
            node(theArc, () -> {
                node(coastal, () -> {
                    node(theIsland, () -> {
                        node(sunkenCity, () -> {
                            node(theBreach, () -> {
                                node(volcanicRemains, () -> {

                                });
                            });
                        });
                    });
                    node(fallenOutpost, () -> {
                        node(kronocia, () -> {
                            node(lostPrison, () -> {
                                node(daybreakEclipse, () -> {

                                });
                                node(midnightShine, () -> {

                                });
                            });
                        });
                    });
                });
            });
        });
        nodeProduce(Items.scrap, () -> {
            nodeProduce(Liquids.slag, () -> {
                nodeProduce(RSItems.gold, () -> {
                    nodeProduce(Liquids.water, () -> {
                        nodeProduce(Liquids.ozone, () -> {

                        });
                        nodeProduce(Liquids.hydrogen, () -> {
                            nodeProduce(RSItems.plasteel, () -> {

                            });
                        });
                    });
                });
            });
            nodeProduce(RSItems.cobalt, () -> {
                nodeProduce(Liquids.cryofluid, () -> {

                });
                nodeProduce(Items.thorium, () -> {
                    nodeProduce(Items.surgeAlloy, () -> {

                    });
                    nodeProduce(Items.phaseFabric, () -> {

                    });
                    nodeProduce(Liquids.neoplasm, () -> {

                    });
                });
            });
            nodeProduce(Items.sand, () -> {
                nodeProduce(Items.coal, () -> {
                    nodeProduce(Items.pyratite, () -> {
                        nodeProduce(Items.blastCompound, () -> {

                        });
                    });
                    nodeProduce(Items.graphite, () -> {
                        nodeProduce(Items.silicon, () -> {

                        });
                    });
                    nodeProduce(Items.metaglass, () -> {

                    });
                });
            });
        });
    }
}