package grafana.workshop

import io.micrometer.core.instrument.MeterRegistry
import org.slf4j.LoggerFactory
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.lang.Thread.sleep
import kotlin.random.Random

@SpringBootApplication
@EnableScheduling
class GrafanaWorkshopApplication

fun main(args: Array<String>) {
	runApplication<GrafanaWorkshopApplication>(*args)
}

@Configuration
class config {
	@Bean
	fun commonTags(): MeterRegistryCustomizer<MeterRegistry> = MeterRegistryCustomizer {
		it.config().commonTags("app", "cool-app");
	}
}

@Service
class AnInterestingJob(registry: MeterRegistry) {
	companion object {
		val log = LoggerFactory.getLogger(AnInterestingJob::class.java)
	}

    // TODO add some metrics!
    val counter = registry.counter("we-did-the-things");
	val timer = registry.timer("how-long-it-took");

	@Scheduled(fixedRate = 5000)
	fun relaxForABit() {
		log.info("Running!")
		val delayMs = Random.nextLong(4000)
		sleep(delayMs)

//		counter.increment()
//		timer.record {
//		}
	}
}
