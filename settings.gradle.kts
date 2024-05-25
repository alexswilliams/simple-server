import de.fayard.refreshVersions.core.FeatureFlag.*
import de.fayard.refreshVersions.core.StabilityLevel

rootProject.name = "simple-server"


plugins {
    id("de.fayard.refreshVersions") version "0.60.5"
}

refreshVersions {
    rejectVersionIf {
        candidate.stabilityLevel != StabilityLevel.Stable
    }
    featureFlags {
        enable(VERSIONS_CATALOG)
        enable(GRADLE_UPDATES)
    }
}
