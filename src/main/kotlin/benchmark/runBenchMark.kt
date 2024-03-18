package benchmark
import org.openjdk.jmh.annotations.*
import java.util.concurrent.*
import kotlin.math.cos
import kotlin.math.sqrt
import kotlin.random.Random

@State(Scope.Benchmark)
@Fork(1)
@Warmup(iterations = 10)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
class MyBenchmark {
    private var data = 0.0

    @Setup
    fun setUp() {
        data = Random.nextDouble()
    }

    @Benchmark
    fun sqrtBenchmark(): Double {
        return sqrt(data)
    }

    @Benchmark
    fun cosBenchmark(): Double {
        return cos(data)
    }
}