package ni.devotion.catfactsapp.intent

sealed class Intent {
    object GetDogEvent: Intent()
    object None: Intent()
}