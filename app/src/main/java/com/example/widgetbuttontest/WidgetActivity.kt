package com.example.widgetbuttontest

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

class widgetActivity : AppWidgetProvider() {
    private val MY_WIDGET_ACTION = "android.action.MY_WIDGET_ACTION"


    private fun setMyaction(context: Context?): PendingIntent {
        val intent = Intent(context, MainActivity::class.java)
        return PendingIntent.getActivity(context, 0, intent, 0)
    }

    private fun addViews(context: Context?): RemoteViews {
        val views = RemoteViews(context?.packageName, R.layout.activity_widget)
        views.setOnClickPendingIntent(R.id.button, setMyaction(context))
        return views
    }

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        appWidgetIds?.forEach { appWidgetIds ->
            val views: RemoteViews = addViews(context)
            appWidgetManager?.updateAppWidget(appWidgetIds, views)
        }
    }
}