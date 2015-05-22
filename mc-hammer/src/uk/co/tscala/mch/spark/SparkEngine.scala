
trait SparkEngine {
  def submit[T](s: SparkTask) : T
}

