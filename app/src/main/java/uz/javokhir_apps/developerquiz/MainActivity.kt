package uz.javokhir_apps.developerquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import uz.javokhir_apps.developerquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList: MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModelList= mutableListOf()
        getDataFromFirebase()
    }
    private fun setupRecyclerView(){
        adapter= QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter
    }
    private fun getDataFromFirebase(){

        val listQuestionModel= mutableListOf<QuestionModel>()
        listQuestionModel.add(QuestionModel("fdfsdfgf", mutableListOf("dd","dd","dddd","ddd"),"dd"))
        listQuestionModel.add(QuestionModel("dfg", mutableListOf("dd","dd","dddd","ddd"),"dd"))

        quizModelList.add(QuizModel("1","Android","All the basic programming","15",listQuestionModel))
        setupRecyclerView()
    }
}