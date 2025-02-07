package com.example.mad_practical_1_osinada

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    private val tasks = mutableListOf<Task>()

    data class Task(val description: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val taskInput = findViewById<EditText>(R.id.taskInput)
        val addTaskButton = findViewById<Button>(R.id.addTaskButton)
        val clearTasksButton = findViewById<Button>(R.id.clearTasksButton)
        val taskList = findViewById<TextView>(R.id.taskList)


        addTaskButton.setOnClickListener {
            val taskText = taskInput.text.toString()
            if (taskText.isNotEmpty()) {
                tasks.add(Task(taskText))
                updateTaskList(taskList)
                taskInput.text.clear()
            }
        }

        clearTasksButton.setOnClickListener {
            tasks.clear()
            updateTaskList(taskList)
        }
    }

    private fun updateTaskList(taskList: TextView) {
        taskList.text = if (tasks.isEmpty()) {
            "Tasks will appear here"
        } else {
            tasks.joinToString("\n") { it.description }
        }
    }
}
