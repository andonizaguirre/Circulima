package pe.edu.ulima.circulima_v1


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import pe.edu.ulima.circulima_v1.fragments.ListaCirculosFragment
import pe.edu.ulima.circulima_v1.fragments.ListaPublicacionesFragment

class MainActivity : AppCompatActivity() {

    private val fragmentCirculos = ListaCirculosFragment()
    private val fragmentPublicaciones = ListaPublicacionesFragment()
    var eteNombre: TextView?=null;
    var eteCorreo: TextView?=null;
    private lateinit var nviMain: NavigationView

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        auth = FirebaseAuth.getInstance()


        nviMain= findViewById(R.id.nviMain);
        eteNombre = nviMain.getHeaderView(0).findViewById(R.id.eteNombre)
        eteCorreo= nviMain.getHeaderView(0).findViewById(R.id.eteCorreo)
        val email = intent.getStringExtra("email")
        val givenName = intent.getStringExtra("givenName")
        val familyName = intent.getStringExtra("familyName")
        val displayName = intent.getStringExtra("displayName")
        eteNombre!!.setText(displayName.toString())
        eteCorreo!!.setText(email.toString())

        val btnLogout = nviMain.getHeaderView(0).findViewById<View>(R.id.btnLogout)
        
        btnLogout.setOnClickListener{
            auth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
        }

        println("INFO RECUPERADA")
        println(email)
        println(givenName)
        println(familyName)
        println(displayName)

        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.fcvSecciones, fragmentCirculos)
        ft.commit()

    }
}