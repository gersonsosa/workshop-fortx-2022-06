package eu.luminis.workshop.smallsteps

import com.tngtech.archunit.base.DescribedPredicate.alwaysTrue
import com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.library.Architectures.*

@AnalyzeClasses(packages = ["eu.luminis.workshop.smallsteps"])
object ArchitectureTest {

//    @ArchTest
//    val layerDependenciesAreRespected: LayeredArchitecture = layeredArchitecture()
//        .layer("api").definedBy("eu.luminis.workshop.smallsteps.api..")
//        .layer("logic").definedBy("eu.luminis.workshop.smallsteps.logic..")
//        .layer("persistence").definedBy("eu.luminis.workshop.smallsteps.persistence..")
//        .whereLayer("api").mayNotBeAccessedByAnyLayer()
//        .whereLayer("logic").mayOnlyBeAccessedByLayers("api")
//        .whereLayer("persistence").mayOnlyBeAccessedByLayers("logic")
//        .ignoreDependency(
//            resideInAPackage("eu.luminis.workshop.smallsteps"),
//            alwaysTrue()
//        )

    @ArchTest
    val onionArchitectureIsRespected: OnionArchitecture? = onionArchitecture()
        .domainModels("..logic..")
        .withOptionalLayers(true)
        .adapter("api", "..api..")
        .adapter("persistence", "..persistence..")
        .ignoreDependency(
            resideInAPackage("eu.luminis.workshop.smallsteps"),
            alwaysTrue()
        )

}