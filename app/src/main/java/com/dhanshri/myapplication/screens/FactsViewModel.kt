package com.dhanshri.myapplication.screens

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel(){

    fun generateRandomeFact(selectedAnimal: String): String {
        val factsList = if (selectedAnimal == "Cat") getCatsFacts() else getDogsFacts()
        val randomFact = factsList.random()
        return randomFact
    }
    fun getCatsFacts() : List<String> {
        val factsList = listOf<String>(
            "Cats are the most popular pet in the United States: There are 88 million pet cats and 74 million dogs.",
            "There are cats who have survived falls from over 32 stories (320 meters) onto concrete.",
            "A group of cats is called a clowder.",
            "Cats have over 20 muscles that control their ears.",
            "Cats sleep 70% of their lives.",
            "A cat has been mayor of Talkeetna, Alaska, for 15 years. His name is Stubbs.",
            "And one ran for mayor of Mexico City in 2013.",
            "In tigers and tabbies, the middle of the tongue is covered in backward-pointing spines, used for breaking off and gripping meat.",
            "When cats grimace, they are usually “taste-scenting.” They have an extra organ that, with some breathing control, allows the cats to taste-sense the air.",
            "Cats can’t taste sweetness.",
            "Owning a cat can reduce the risk of stroke and heart attack by a third.",
            "Wikipedia has a recording of a cat meowing because why not?",
            "The world’s largest cat measured 48.5 inches long.",
            "Evidence suggests domesticated cats have been around since 3600 B.C., 2,000 years before Egypt’s pharaohs.",
            "A cat’s purr may be a form of self-healing, as it can be a sign of nervousness as well as contentment.",
            "Adult cats only meow to communicate with humans.",
            "The world’s richest cat is worth $13 million after his human passed away and left her fortune to him.",
            "Your cat recognizes your voice but just acts too cool to care (probably because they are).",
            "Cats are often lactose intolerant, so stop givin’ them milk!",
            "Basically all cartoon cats lied to us: Raw fish is off the table for cats as well.",
            "The oldest cat video on YouTube dates back to 1894 (when it was made, not when it was uploaded, duh).",
            "In the 1960s, the CIA tried to turn a cat into a bonafide spy by implanting a microphone into her ear and a radio transmitter at the base of her skull. She somehow survived the",
            "operation but got hit by a taxi on her first mission.",
        )

        return factsList
    }

    fun getDogsFacts() : List<String>{
        val dogFacts = listOf(
            "Dogs noses are wet to help absorb scent chemicals",
            "Newfoundlands are amazing lifeguards",
            "The Beatles song ‘A Day in the Life’ has a frequency only dogs can hear",
            "Three dogs survived the Titanic sinking",
            "A Bloodhound’s sense of smell can be used as evidence in court",
            "The Saluki is the oldest dog breed",
            "Dogs have three eyelids",
            "Basenji dogs don’t bark",
            "The shape of a dog’s face suggests how long it will live",
            "Dogs can see in colour",
            "Dogs can smell disease",
            "Dogs can be trained to detect cancer and other diseases in humans",
            "Dogs can see in the dark",
            "Dogs can sense storms",
            "Dogs can sense sadness in humans",
            "Dogs can sense pregnancy",
            "Dogs can sense earthquakes",
            "Dogs can sense time",
            "Dogs can smell feelings",
            "Dogs can smell your feelings",
        )

        return dogFacts
    }

}