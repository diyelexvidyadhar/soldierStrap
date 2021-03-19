package com.example.soldierstrap

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.soldierstrap.data.Soldier
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SoldierViewModel : ViewModel() {
    private val dbSoldier = FirebaseDatabase.getInstance().getReference("soldiers")
    private val _soldiers = MutableLiveData<List<Soldier>>()
    val soldier: LiveData<List<Soldier>>
        get() = _soldiers

    fun fetchSoldierData() {
        dbSoldier.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val soldiers = mutableListOf<Soldier>()
                    for (soldierSnapshot in snapshot.children) {
//                        val soldier = soldierSnapshot.getValue(Soldier::class.java)
//                        soldier?.id = soldierSnapshot.key
//                        soldier?.let { soldiers.add(it) }
                        var soldierName = soldierSnapshot.key
                        var atmosPressure = soldierSnapshot.child("Atmospheric Pressure").value.toString()
                        var atmostemp = soldierSnapshot.child("Atmospheric Temperature").value.toString()
                        var bloodPressure = soldierSnapshot.child("BloodPressure").value.toString()
                        var bodyTemp = soldierSnapshot.child("BodyTemp").value.toString()
                        var elevation = soldierSnapshot.child("Elevation").value.toString()
                        var heartRate = soldierSnapshot.child("HeartRate").value.toString()
                        var windSpeed = soldierSnapshot.child("Wind Speed").value.toString()
                        val soldier = Soldier(
                            soldierName,
                            atmosPressure,
                            atmostemp,
                            bloodPressure, bodyTemp,
                            elevation, heartRate, windSpeed
                        )
                        soldiers.add(soldier)

                    }
                    _soldiers.value = soldiers
                }

            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }
}