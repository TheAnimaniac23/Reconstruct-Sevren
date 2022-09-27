import mindustry.content;

import arc.struct.*;
import mindustry.game.Objectives.*;

import static mindustry.content.blocks.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.SectorPresets.craters;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class SevrenTechTree {
    public static void load() {
        Planets.sevren.techtree = nodeRoot("sevren", coreDebris, () -> {
            node(scrapConveyor, () -> {
                node(scrapJunction, () -> {
                    node(scrapRouter, () -> {
                        node(cobaltContainer, () -> {
                            node(cobaltVault, () -> {

                            });
                            node(cobaltUnloader, () -> {

                            });
                        });
                        node(scrapBridge, () -> {
                            node(goldConveyor, () -> {
                                node(phaseBridge, () -> {
                                    node(PhaseRouter, () -> {
                                        node(reforgedMassDriver, () -> {
                                            node(reforgedPayloadMassDriver, () -> {
                                                node(reforgedPayloadPropulsionTower, () -> {

                                                });
                                            });
                                            node(plasteelBuildTower, () -> {

                                            });
                                        });
                                    });
                                });
                                node(scrapPayloadConveyor, () -> {
                                    node(scrapPayloadRouter, () -> {
                                        node(scrapPayloadBridge, () -> {

                                        });
                                    });
                                });
                                node(cobaltArmoredConveyor, () -> {
                                    node(thoriumConveyor, () -> {
                                        node(thoriumRouter, () -> {

                                        });
                                    });
                                });
                                node(scrapConstructor, () ->  {
                                    node(scrapPayloadLoader, () -> {
                                        node(scrapPayloadUnloader, () -> {

                                        });
                                    });
                                    node(scrapDeconstructor, () -> {
                                        node(massScrapDeconstructor, () -> {

                                        });
                                    });
                                    node(massScrapConstructor, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
            });
            node(coreRemnant, () -> {
                node(coreFragment, () -> {

                });
            });
            node(mechanicalPumpDrill, () -> {
                node(cometSling, () -> {
                    node(scrapConduit, () -> {
                        node(scrapConduitJunction, () -> {
                            node(scrapConduitRouter, () -> {
                                node(goldFluidTank, () -> {
                                    node(cobaltFluidTank, () -> {

                                    });
                                });
                                node(scrapConduitBridge, () -> {
                                    node(phaseConduitBridge, () -> {

                                    });
                                });
                                node(cobaltConduit, () -> {

                                });
                                node(fluidPump, () -> {
                                    node(largeFluidPump, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
                node(goldRefinery, () -> {
                    node(hydrokineticDrill, () -> {
                        node(thoriumDrill, () -> {
                            node(blastDrill, () -> {

                            });
                        });
                    });
                    node(pyratiteMelder, () -> {
                        node(plasteelBlastMixer, () -> {

                        });
                    });
                    node(sandCrusher, () -> {
                        node(graphiteInfuser, () -> {
                            node(siliconFrostforge, () -> {
                                node(plasteelCrucible, () -> {
                                    node(phaseForge, () -> {

                                    });
                                });
                            });
                        });
                        node(slagMelter, () -> {
                            node(cobaltExtractor, () -> {
                                node(pyrokiln, () -> {

                                });
                                node(meteorSling, () -> {
                                    node(cryofluidSynthesizer, () -> {

                                    });
                                    node(surgeBlaster, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
                node(metaglassSolarPanel, () -> {
                    node(powerPropulsor, () -> {
                        node(powerRouter, () -> {
                            
                        });
                        node(regenerativeTurret, () -> {
                            node(phaseShieldGenerator, () -> {
                                node(overdriver, () -> {
                                    node(plasteelOverdriver, () -> {
                                        node(pulsewaveTower, () -> {

                                        });
                                    });
                                });
                            });
                        });
                        node(largeMetaglassSolarPanel, () -> {
                            node(phasePanel, () -> {
                                node(largePhasePanel, () -> {
                                    node(fragmentedNeoplasiaReactor, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
        node(scrappedDuo, () -> {
            node(refinedScrapWall, () -> {
                node(largeRefinedScrapWall, () -> {
                    node(goldWall, () -> {
                        node(largeGoldWall, () -> {

                        });
                        node(refinedScrapDoor, () -> {
                            node(largeRefinedScrapDoor, () -> {
                                node(autoRefinedScrapDoor, () -> {

                                });
                            });
                        });
                        node(plasteelWall, () -> {
                            node(largePlasteelWall, () -> {

                            });
                        });
                        node(cobaltWall, () -> {
                            node(largeCobaltWall, () -> {

                            });
                            node(surgeWall, () -> {
                                node(LargeSurgeWall, () -> {

                                });
                            });
                        });
                    });
                });
            });
            node(scrapHail, () -> {
                node(lavaflowTurret, () -> {
                    node(slagPropulsor, () -> {

                    });
                });
            });
            node(scrapTurret, () -> {
                node(reinforcedScrapTurret, () -> {
                    node(voidedTurret, () -> {
                        node(multiTurret, () -> {
                            node(chargeTurret, () -> {
                                node(anarchyTurret, () -> {
                                    node(neoplasiaMeteorTurret, () -> {

                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
        node(spiderUnitFactory, () -> {
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
            node(hoverUnitFactory, () -> {
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
                node(boatUnitFactory, () -> {
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
            node(pointRefabricator, () -> {
                node(lineRefabricator, () -> {
                    node(planeRefabricator, () -> {
                        node(polygonRefabricator, () -> {

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
                nodeProduce(Items.gold, () -> {
                    nodeProduce(Liquids.water, () -> {
                        nodeProduce(Liquids.ozone, () -> {

                        });
                        nodeProduce(Liquids.hydrogen, () -> {
                            nodeProduce(Items.plasteel, () -> {

                            });
                        });
                    });
                });
            });
            nodeProduce(Items.cobalt, () -> {
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