package nz.co.eroad.grafanaworkshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrafanaWorkshopApplication

fun main(args: Array<String>) {
	runApplication<GrafanaWorkshopApplication>(*args)
}
