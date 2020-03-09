package nz.co.eroad.grafanaworkshop

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
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

@Service
class AnInterestingJob(registry: MeterRegistry) {
    // TODO add some metrics!
    val counter = registry.counter("we-did-the-things");
	val timer = registry.timer("how-long-it-took");

	@Scheduled(fixedRate = 5000)
	fun relaxForABit() {
        counter.increment();

		timer.record {
			val delayMs = Random.nextLong(1000)
			sleep(delayMs)
		}
	}
}
