package com.example.notesappbyfsa.ui.customViews

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import com.example.notesappbyfsa.R

class CreateNoteView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyle: Int = 0, defStyleRes: Int = 0
) : CardView(context, attrs, defStyle) {

    private var ivLogo: ImageView
    private var cvCard: CardView

    private var color: Int? = null
    set (value){
        field  = value
        value?.let { cvCard.setCardBackgroundColor(it)}
    }

    private var logo: Drawable? = null
        set(value){
            field = value
            value?.let { ivLogo.setImageDrawable(it) }
        }

    init {
        val layout = LayoutInflater.from(context).inflate(R.layout.create_note, this, true)
        layout.setBackgroundColor(127)

        ivLogo = layout.findViewById(R.id.ivLogo)
        cvCard = layout.findViewById(R.id.cvCard)

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CreateNoteView)
            color = typedArray.getColor(R.styleable.CreateNoteView_cardColor, 255)

            val logoRes = typedArray.getResourceId(R.styleable.CreateNoteView_icon, -1)
            if(logoRes != -1){
                logo = AppCompatResources.getDrawable(context, logoRes)
            }
            typedArray.recycle()
        }
    }
}