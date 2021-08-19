package com.fred.moviez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFilm : AppCompatActivity(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var List: ArrayList<Film>
    lateinit var itemImages : Array<Int>
    lateinit var itemTitles : Array<String>
    lateinit var itemRating : Array<String>
    lateinit var itemGenre : Array<String>
    lateinit var trailerId : Array<String>
    lateinit var itemDuration : Array<String>
    lateinit var itemDirector : Array<String>
    lateinit var itemRelease : Array<String>
//    lateinit var filmRate : Array<String>
    lateinit var itemDesc : Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        itemImages = arrayOf(
            R.drawable.black_widow,
            R.drawable.snake_eyes,
            R.drawable.hitmans,
            R.drawable.space_jam,
            R.drawable.the_boss_baby,
            R.drawable.escape_room,
            R.drawable.quiet_place,
            R.drawable.conjuring,
            R.drawable.kings_man,
            R.drawable.peter_rabbit,
            R.drawable.godzilla_kong,
            R.drawable.mortal_kombat,
            R.drawable.venom,
            R.drawable.fast_furious_9,
            R.drawable.in_the_heights,
        )

        itemTitles = arrayOf(
            "BLACK WIDOW",
            "SNAKE EYES",
            "HITMANS WIFES BODYGUARD",
            "SPACE JAM: A NEW LEGACY",
            "THE BOSS BABY: FAMILY BUSINESS",
            "ESCAPE ROOM: TOURNAMENT OF CHAMPIONS",
            "A QUIET PLACE PART II",
            "THE CONJURING: THE DEVIL MADE ME DO IT",
            "THE KING'S MAN",
            "PETER RABBIT 2: THE RUNAWAY",
            "GODZILLA VS KONG",
            "MORTAL KOMBAT",
            "VENOM: LET THERE BE CARNAGE",
            "FAST & FURIOUS 9",
            "IN THE HEIGHTS"
        )

        itemRating = arrayOf(
            "R 13+",
            "R 13+",
            "D 17+",
            "SU",
            "SU",
            "R 13+",
            "R 13+",
            "D 17+",
            "R 13+",
            "SU",
            "R 13+",
            "D 17+",
            "R 13+",
            "R 13+",
            "R 13+",
        )

        itemGenre = arrayOf(
            "Action, Adventure,Sci-fi",
            "Action",
            "Action, Comedy, Crime",
            "Animation",
            "Animation, Adventure, Comedy",
            "Thriller",
            "Sci-fi, Thriller, Horror",
            "Horror, Mystery, Thriller",
            "Action, Adventure, Comedy",
            "Adventure, Comedy, Family",
            "Action, Sci-fi, Thriller",
            "Action, Fantasy, Adventure",
            "Action, Thriller",
            "Action, Crime, Thriller",
            "Drama, Music, Romance",
        )

        trailerId = arrayOf(
            "Fp9pNPdNwjI",
            "yLDOSOHZ62g",
            "l4I2Q9M7MJ0",
            "pUgDGDjbCzo",
            "kr4wl1oGCzU",
            "wNo6ITgrX8k",
            "jXqC8gWx7xc",
            "Gjtgzzzlg8s",
            "WgjM7ia0oP4",
            "0ULKkPqOPC8",
            "8l3aQ9H9Zeg",
            "F0corp44QTI",
            "ueXkLEpJBPU",
            "U19dn2tydgc",
            "p066qJ0gPrk",
        )

        itemDuration = arrayOf(
            "134 minutes",
            "121 minutes",
            "116 minutes",
            "115 minutes",
            "108 minutes",
            "98 minutes",
            "97 minutes",
            "111 minutes",
            "131 minutes",
            "93 minutes",
            "113 minutes",
            "110 minutes",
            "-",
            "145 minutes",
            "143 minutes",
        )

        itemDirector = arrayOf(
            "Cate Shortland",
            "Robert Schwentke",
            "Patrick Hughes",
            "Malcolm D. Lee",
            "Tom McGrath",
            "Adam Robitel",
            "John Krasinski",
            "Michael Chaves",
            "Matthew Vaughn",
            "Will Gluck",
            "Adam Wingard",
            "Simon McQuoid",
            "Andy Serkis",
            "Justin Lin",
            "Jon M. Chu",
        )

        itemRelease = arrayOf(
            "July 9, 2021",
            "August 31, 2021",
            "June 10, 2021",
            "July 16, 2021",
            "July 2, 2021",
            "July 14, 2021",
            "May 26, 2021",
            "June 4, 2021",
            "December 22, 2021",
            "June 23, 2021",
            "March 24, 2021",
            "April 14, 2021",
            "October 15, 2021",
            "June 16, 2021",
            "June 9, 2021",
        )

//        -filmRate = arrayOf(
//            "R 13+",
//            "R 13+",
//            "D 17+",
//            "SU",
//            "SU",
//            "R 13+",
//            "R 13+",
//            "D 17+",
//            "R 13+",
//            "R 13+",
//            "R 13+",
//            "D 17+",
//            "R 13+",
//            "R 13+",
//            "R 13+",
//        )

        itemDesc = arrayOf(
            "Natasha Romanoff, also known as Black Widow, confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises. Pursued by a force that will stop at nothing to bring her down, Natasha must deal with her history as a spy and the broken relationships left in her wake long before she became an Avenger",
            "All bets are off when corrupt homicide cop Rick Santoro witnesses a murder during a boxing match. It's up to him and lifelong friend and naval intelligence agent Kevin Dunne to uncover the conspiracy behind the killing. At every turn, Santoro makes increasingly shocking discoveries that even he can't turn a blind eye to.",
            "The world's most lethal odd couple - bodyguard Michael Bryce and hitman Darius Kincaid - are back on another life-threatening mission. Still unlicensed and under scrutiny, Bryce is forced into action by Darius's even more volatile wife, the infamous international con artist Sonia Kincaid. As Bryce is driven over the edge by his two most dangerous protectees, the trio get in over their heads in a global plot and soon find that they are all that stand between Europe and a vengeful and powerful madman.",
            "When LeBron and his young son Dom are trapped in a digital space by a rogue A.l., LeBron must get them home safe by leading Bugs, Lola Bunny and the whole gang of notoriously undisciplined Looney Tunes to victory over the A.l's digitized champions on the court. It's Tunes versus Goons in the highest-stakes challenge of his life.",
            "The Templeton brothers have grown up and drifted apart from each other, but the arrival of a new Boss Baby with something cutting edge will bring them together again and also inspire a new family business.",
            "Six people unwittingly find themselves locked in another series of escape rooms, slowly uncovering what they have in common to survive as they discover all the games that they've played before.",
            "A Quiet Place: Part II continues the story of the Abbott family in survival after the arrival of alien creatures on Earth. At the beginning of the film, there will be the first day, aka Day One, which shows a glimpse of how the creature came. Chaos started. Then the story will switch to a time when the Abbott family managed to survive the attack of these creatures. But they are still in shock after losing the head of the family. They were forced to do the unthinkable, which was to leave. They continue to face various threats. Many unexpected new dangers will test every member of the family and their bonds. The writer, director and co-producer of A Quiet Place: Part II,",
            "The story is on November 24, 1981 in Brookfield, Connecticut, Arne Cheyenne Johnson is tried in the first degree murder case for the death of a landlord named Alan Bono. The case became famous because it involved, for the first time, \"devil-possessed\" elements in a murder trial.",
            "A veteran of a secret service recruits teenagers to be trained to become a great secret agent.",
            "Bea, Thomas, and the rabbits have created a makeshift family, but despite his best efforts, Peter can't seem to shake his mischievous reputation. Adventuring out of the garden, Peter finds himself in a world where his mischief is appreciated, but when his family risks everything to come looking for him, Peter must figure out what kind of bunny he wants to be.",
            "As monsters walk the Earth, humanity's struggle for its future puts Godzilla and Kong on a collision course that will see two of the most powerful natural forces on the planet collide in a spectacular battle for centuries.",
            "Washed-out MMA fighter Cole Young, unaware of his legacy, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champion as he prepares to take on Outworld's foes in a high-stakes battle for the universe.",
            "Venom: Let There Be Carnage tells the story of Eddie Brock's life as an investigative reporter. Brock's online events fall apart after he goes after Carlton Drake and the Life Foundation, who brought back aliens from a secret space mission. Brock is fired from his job and loses his fiancé, Anne Weying, who also lost his job after Brock illegally used legal information from him to accuse Drake. However, Brock is pulled back into the Life Foundation's investigation by one of the company's doctors. The doctor wanted to explain the fatal test carried out on homeless people in San Francisco. The Life Foundation seeks to create a bond between humans and the alien symbiotes they brought back to earth. After Eddie Brock breaks into the lab, he is attacked by one of the failed symbiote bonds and becomes his first encounter with the symbiote Venom. Meanwhile, another symbiote escapes and travels to San Francisco. They bonded with Carlton Drake to create the villain known as Riot. Venom and Eddie can find new strength in their relationship, and a new mission to stop Riot from calling for a symbiote invasion. Venom is able to stop Riot and save his career as Eddie Brock while renewing his friendship with Anne. All lead to a highly acclaimed interview with serial killer Cletus Kasady.",
            "Dom Toretto (Vin Diesel) lives a quiet life with Letty and his son, little Brian, but they know that danger is always lurking. This time, the threat will force Dom to confront the mistakes of his past if he is to save the person he loves the most. His crew joins together to stop something that could destroy the world. The attack is led by the most skilled assassin and highly skilled driver and also Dom's abandoned brother, Jakob (John Cena)",
            "The story of Usnavi, a bodega owner who has mixed feelings about closing his shop and retiring to the Dominican Republic or living in Washington Heights.",
        )

        List = arrayListOf<Film>()
        for(i in itemImages.indices)
            List.add(Film(itemImages[i],itemTitles[i],itemRating[i],itemGenre[i],trailerId[i],itemDuration[i],itemDirector[i],itemRelease[i],itemDesc[i]))

        recyclerView = findViewById(R.id.recycler_View)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MyAdapter(List)
        {
            val intent = Intent(this@ListFilm, FilmDescription::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)
        }
    }
}