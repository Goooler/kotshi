import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

val LibrariesForLibs.oldestSupportedMoshi: Provider<MinimalExternalModuleDependency>
    get() = versions.moshi.oldestSupported.flatMap { version ->
        moshi.latest.map { dep ->
            dep.copy().apply {
                version {
                    require(version)
                }
            }
        }
    }

internal val Project.libs: LibrariesForLibs get() = extensions.getByType()
